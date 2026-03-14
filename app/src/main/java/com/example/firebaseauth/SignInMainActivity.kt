package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaseauth.databinding.ActivitySignInMainBinding
import com.example.firebaseauth.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignInMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth= FirebaseAuth.getInstance()
        binding.tvSignUpLink.setOnClickListener {

            startActivity(Intent(this@SignInMainActivity, SignUpActivity::class.java))
            Toast.makeText(this, "Nevigate To SignUp Page", Toast.LENGTH_SHORT)

            if (auth.currentUser != null) {
                Toast.makeText(this, "User Is Already Login", Toast.LENGTH_SHORT)

                startActivity(Intent(this, HomeScreen::class.java))
                finish()
            }


        }

        binding.btnSignIn.setOnClickListener {

            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, HomeScreen::class.java))
                    }

                }


        }

    }
}