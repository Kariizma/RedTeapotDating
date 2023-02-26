package com.example.redteapotdating.viewmodels

import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redteapotdating.API.RedTeapotDatingApiService
import com.example.redteapotdating.API.RetrofitInstance
import com.example.redteapotdating.models.Users
import kotlinx.coroutines.launch

class DatingViewModel: ViewModel() {

    //internal mutable data
    private var _users = MutableLiveData<List<Users>>()
    private var _counter = MutableLiveData<Int>(0)

    //external immutable data
    val users: LiveData<List<Users>> = _users
    val counter: LiveData<Int> = _counter

    init{
        getUsers()
    }

    /**
     * Gets [Users] information from the [RedTeapotDatingApiService] using Retrofit and Moshi Json Converter
     */
    private fun getUsers() {
        viewModelScope.launch {
            Log.v("getUsers()", "Loading...")
            try {
                _users.value = RetrofitInstance.api.getUsers()
                Log.v("getUsers()", "Success!, the data has been retrieved from the API")
            } catch (e: Exception) {
                Log.e("getUsers()", "Failure: ${e.message}")
                _users.value = listOf()
            }
        }
    }

    /**
     * Increments the counter to get the next data from the Users list.
     */
    fun incrementButton()
    {
        if(_counter.value!! < _users.value!!.size)
            _counter.value = (_counter.value)?.plus(1)
    }
}