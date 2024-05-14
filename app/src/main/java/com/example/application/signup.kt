package com.example.application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var signUpButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()
        signUpButton = findViewById(R.id.sign_up)
        login = findViewById(R.id.textView11)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)

        login.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                showToast("Please fill in all fields.")
                return@setOnClickListener
            }

            // Firebase authentication
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign up successful, navigate to the home screen
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)
                        showToast("Sign up successful!")
                    } else {
                        // Sign up failed, handle the error here
                        showToast("Sign up failed. Please try again.")
                    }
                }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
