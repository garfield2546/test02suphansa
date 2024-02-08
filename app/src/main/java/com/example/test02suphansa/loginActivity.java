package com.example.test02suphansa;


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ez06.MainActivity
import com.example.loginsignupauth.databinding.ActivityLoginBinding
import com.example.loginsignupauth.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

private lateinit var binding: ActivityLoginBinding
private lateinit var firebaseAuth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
        firebaseAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this){task ->
        if (task.isSuccessful){
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
        } else {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT)
        }
        }
        } else {
        Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT)
        }
        }
        binding.signupText.setOnClickListener{
        startActivity(Intent(this, MainActivity::class.java))
        finish()
        }
        }
        }package com.example.loginsignupauth

        import androidx.test.platform.app.InstrumentationRegistry
        import androidx.test.ext.junit.runners.AndroidJUnit4

        import org.junit.Test
        import org.junit.runner.RunWith

        import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.loginsignupauth", appContext.packageName)
    }
}