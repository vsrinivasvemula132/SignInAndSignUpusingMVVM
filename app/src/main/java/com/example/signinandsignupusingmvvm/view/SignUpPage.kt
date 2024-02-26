package com.example.signinandsignupusingmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.signinandsignupusingmvvm.databinding.ActivitySignUpPageBinding
import com.example.signinandsignupusingmvvm.viewmodel.AuthViewModel

class SignUpPage : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpPageBinding

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        binding.signupBtn.setOnClickListener {
            val email1  =binding.etEmail1.text.toString()
            val password1 = binding.etPassword1.text.toString()

            viewModel.signup(email1,password1)
        }

        viewModel.signupStatus.observe(this) { signedUp ->

            if (signedUp) {
                // Show success message or navigate back to login activity upon successful signup
                val intent = Intent(this,HomePage::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Invalid email or password",Toast.LENGTH_LONG).show()
            }
        }

        binding.loginText.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



}