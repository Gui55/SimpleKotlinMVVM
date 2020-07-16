package com.example.simplemvvmkotlin.repository

import androidx.lifecycle.MutableLiveData
import com.example.simplemvvmkotlin.model.User

class UserRepository {

    companion object{
        val instance = UserRepository()
    }

    fun getTheUsers() : MutableLiveData<ArrayList<User>>{

        var userArrayList = arrayListOf<User>()

        userArrayList.add(User("Guilherme", "animeGirlsAreAwesome"))
        userArrayList.add(User("Rogerio", "12345"))
        userArrayList.add(User("Fernando", "12345"))
        userArrayList.add(User("Jefferson", "12345"))
        userArrayList.add(User("Prabal", "12345"))

        var usersLiveData = MutableLiveData<ArrayList<User>>()

        usersLiveData.value = userArrayList

        return usersLiveData
    }

}