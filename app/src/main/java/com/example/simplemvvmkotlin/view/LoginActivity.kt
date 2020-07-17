package com.example.simplemvvmkotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getTheRepositoryUsers().observe(this, object: Observer<ArrayList<User>>{
            override fun onChanged(t: ArrayList<User>?) {

                btnEnter.setOnClickListener {
                    for (i in t!!) {
                        if (edtName.text.toString().equals(i.name) && edtPassword.text.toString().equals(i.phrase)) {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            Toast.makeText(this@LoginActivity,"usuario não existe",Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }

        })

    }
}