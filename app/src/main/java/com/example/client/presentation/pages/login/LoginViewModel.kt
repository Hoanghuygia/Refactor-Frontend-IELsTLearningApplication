package com.example.client.presentation.pages.login

import android.content.Context
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.client.BuildConfig
import com.example.client.domain.model.User
import com.example.client.domain.usecase.localapp.AppUsecase
import com.example.client.presentation.navgraph.Route
import com.example.client.utils.TypeTextFieldX
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.security.MessageDigest
import java.util.UUID
import javax.inject.Inject
import com.example.client.R

@HiltViewModel
class LoginViewModel @Inject constructor(private val appUsecase: AppUsecase) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun updateTextField(content: String, type: String) {
        _uiState.update { currentState ->
            when (type) {
                TypeTextFieldX.EMAIL.type -> currentState.copy(emailTextField = content)
                TypeTextFieldX.LAST_PASSWORD.type -> currentState.copy(passwordTextField = content)
                else -> currentState
            }
        }
    }

    fun toggleCheckbox() {
        _uiState.update { currentState ->
            currentState.copy(rememberMe = !currentState.rememberMe)
        }
    }

    fun loginWithGoogle(context: Context, scope: CoroutineScope, navController: NavController) {
        val credentialManager = CredentialManager.create(context)

        val rawNonce = UUID.randomUUID().toString()
        val bytes = rawNonce.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        val hashedNonce = digest.fold("") { str, it -> str + "%02x".format(it) }

        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(BuildConfig.GOOGLE_WEB_CLIENT_ID)
            .setNonce(hashedNonce)
            .build()

        val request: GetCredentialRequest = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        scope.launch {
            try {
                val result = credentialManager.getCredential(request = request, context = context)
                val googleIdTokenCredential =
                    GoogleIdTokenCredential.createFrom(result.credential.data)

                val googleIdToken = googleIdTokenCredential.idToken
                /*
                Step need to make at here:
                1. Check if user already in database or not
                    If yes: load data
                    If no: crete user
                2. save user into local data
                3. Navigate to main screen
                 */

                // #Step 2
                val payload =
                    JSONObject(String(Base64.decode(googleIdToken.split(".")[1], Base64.URL_SAFE)))
                val email = payload.getString("email")
                val name = payload.getString("name")
                val givenName = payload.getString("given_name")
                val familyName = payload.getString("family_name")

                val user = User(
                    email = email,
                    fullName = name,
                    givenName = givenName,
                    familyName = familyName,
                    avatar = R.drawable.avatar
                )
                appUsecase.saveUser(user)

                // Step 3
                navController.navigate(Route.HomeScreen.route)

                Log.i("payload", "Google ID Token: $payload")
                Log.i("name", "Google ID Token: $name")
                Log.i("idToken", "Google ID Token: $googleIdToken")
                Log.i("email", "User Email: $email")

                Toast.makeText(context, "Signed in as: $email", Toast.LENGTH_SHORT).show()

                Toast.makeText(context, "You are signed in!!", Toast.LENGTH_SHORT).show()

            } catch (e: Exception) {
                Log.e("GoogleSignIn", "Error: ${e.message}", e)
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            } catch (e: GetCredentialException) {
                Log.e("GoogleSignIn", "Error: ${e.message}", e)
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            } catch (e: GoogleIdTokenParsingException) {
                Log.e("GoogleSignIn", "Error: ${e.message}", e)
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}