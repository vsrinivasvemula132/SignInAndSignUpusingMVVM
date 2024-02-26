package com.example.signinandsignupusingmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {

    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean>
        get() = _loginStatus

    private val _signupStatus = MutableLiveData<Boolean>()
    val signupStatus: LiveData<Boolean>
        get() = _signupStatus


    fun login(email2: String, password2: String) {

        // Perform login logic, for simplicity, just check if username and password are not empty
        val loggedIn = email2.isNotBlank() && password2.isNotBlank()
        _loginStatus.value = loggedIn
    }
    fun signup(email1: String, password1: String) {

        // Perform signup logic, for simplicity, just check if username and password are not empty
        val signedUp = email1.isNotBlank() && password1.isNotBlank()
        _signupStatus.value = signedUp
    }
}