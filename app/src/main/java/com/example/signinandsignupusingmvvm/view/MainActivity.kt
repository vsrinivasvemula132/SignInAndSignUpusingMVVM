package com.example.signinandsignupusingmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.signinandsignupusingmvvm.databinding.ActivityMainBinding
import com.example.signinandsignupusingmvvm.viewmodel.AuthViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        binding.loginBtn.setOnClickListener {
            val email2 = binding.etEmail2.text.toString()
            val password2 = binding.etPassword2.text.toString()

            viewModel.login(email2,password2)
        }
        viewModel.loginStatus.observe(this) { loggedIn ->
            if (loggedIn) {
                val intent = Intent(this,HomePage::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Invalid email or password",Toast.LENGTH_LONG).show()
            }
        }

        binding.signupText.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }
    }
}