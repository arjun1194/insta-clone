package com.arjun1194.instaclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.arjun1194.instaclone.R
import com.arjun1194.instaclone.data.model.DataResponse
import com.arjun1194.instaclone.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeData()

    }

    private fun observeData() {
        viewModel.getUsers();
        viewModel.users.observe(this){
            when(it){
                is DataResponse.Error -> toast(it.error.message.toString())
                is DataResponse.Success -> {
                    val textView = findViewById<TextView>(R.id.textView)
                    textView.text = it.data.toString()
                }
            }
        }
    }
}