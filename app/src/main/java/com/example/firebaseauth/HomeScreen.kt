package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaseauth.databinding.ActivityHomeScreenBinding
import com.example.firebaseauth.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class HomeScreen : AppCompatActivity() {
    private  lateinit var binding: ActivityHomeScreenBinding
    private  lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()



        binding.btnLogout.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SignInMainActivity::class.java))
            finish()
        }



    }


}