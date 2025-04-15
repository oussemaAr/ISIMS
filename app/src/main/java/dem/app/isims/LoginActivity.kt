package dem.app.isims

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // 1- step
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // 2- step
        initView()
        // 3 Step
        initEvent()
    }

    private fun initEvent() {
        loginButton.setOnClickListener {
            if (validateInput(emailInput, passwordInput)) {

            }
        }
    }

    private fun validateInput(
        email: EditText,
        password: EditText
    ): Boolean {
        if (email.fetchText().isEmpty() ) {
            email.error = "Required Field"
            return false
        }

        if(!email.fetchText().validate()){
            email.error = "Not Valid email"
            return false
        }
        if (password.fetchText().isEmpty()) {
            password.error = "Required Field"
            return false
        }
        return true
    }

    private fun validate(
        email: String,
        password: String
    ) = email.validate() && password.isNotEmpty()

    private fun initView() {
        emailInput = findViewById<EditText>(R.id.email_input)
        passwordInput = findViewById<EditText>(R.id.password_input)
        loginButton = findViewById<Button>(R.id.login_button)
    }
}

// Kotlin Extensions
fun EditText.fetchText(): String = this.text.toString()

fun String.validate(): Boolean = this.contains("@")