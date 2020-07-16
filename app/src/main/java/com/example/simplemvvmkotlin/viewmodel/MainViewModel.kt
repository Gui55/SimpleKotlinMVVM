package com.example.simplemvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvmkotlin.model.User
import com.example.simplemvvmkotlin.repository.UserRepository

class MainViewModel : ViewModel() {

    fun getTheRepositoryUsers() : MutableLiveData<ArrayList<User>>{

        return UserRepository.instance.getTheUsers()

    }

}