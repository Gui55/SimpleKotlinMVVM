package com.example.simplemvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemvvmkotlin.R
import com.example.simplemvvmkotlin.model.User
import com.example.simplemvvmkotlin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getTheRepositoryUsers().observe(this, object: Observer<ArrayList<User>>{
            override fun onChanged(users: ArrayList<User>?) {

                var textVariable = ""

                for(i in users!!){
                    textVariable += "User: "+i.name+" / Password: "+i.password+"\n"
                }

                textView.text = textVariable
            }

        })

    }
}