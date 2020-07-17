package com.example.simplemvvmkotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemvvmkotlin.R
import com.example.simplemvvmkotlin.model.User
import com.example.simplemvvmkotlin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    fun loginProcess(view: View) {

        if(viewModel.isThereThisUser(edtName.text.toString(), edtPassword.text.toString())){

            startActivity(Intent(this@LoginActivity, MainActivity::class.java))

        } else {

            Toast.makeText(this@LoginActivity,"usuario não existe",Toast.LENGTH_SHORT).show()

        }

    }
}