package com.example.timestest.ui.login

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    // Two-way bound
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _loggedInEvent = MutableLiveData<Pair<String, String>>()
    val loggedInEvent: LiveData<Pair<String, String>> = _loggedInEvent

    init {
        Log.i("LoginViewModel", "LoginViewModel created!")
    }

    override fun onCleared() {
        Log.i("LoginViewModel", "LoginViewModel destroyed!")
    }

    fun performLogin() {
        Log.i("LoginViewModel", "Performing login with username: ${username.value} and password: ${password.value}")

        _loggedInEvent.value = Pair<String, String>(username.value!!, password.value!!)
    }
}