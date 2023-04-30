package com.example.booksapi_mvvm_databinding.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.booksapi_mvvm_databinding.R
import com.example.booksapi_mvvm_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
    }

    private fun setup() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        addCallBacks()
    }

    private fun addCallBacks() {
       viewModel.toastMessage.observe(this){
           createToast(it?:"error occurred")
       }
    }

    private fun createToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}