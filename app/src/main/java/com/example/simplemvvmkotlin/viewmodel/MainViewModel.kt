package com.example.simplemvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvmkotlin.model.User
import com.example.simplemvvmkotlin.repository.UserRepository

class MainViewModel : ViewModel() {

    var repositoryUsers = UserRepository.instance.getTheUsers()

    fun getTheRepositoryUsers() : MutableLiveData<ArrayList<User>>{

        return repositoryUsers

    }

    fun isThereThisUser(name: String, pass: String) : Boolean{

        var isThere = false

        for(i in repositoryUsers.value!!){

            if(i.name==name && i.phrase==pass){

                isThere = true
                break

            }

        }

        return isThere

    }

}