package com.arjun1194.instaclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil.setContentView
import com.arjun1194.instaclone.R
import com.arjun1194.instaclone.data.model.DataResponse
import com.arjun1194.instaclone.databinding.ActivityMainBinding
import com.arjun1194.instaclone.ui.adapters.FeedAdapter
import com.arjun1194.instaclone.ui.adapters.StoriesAdapter
import com.arjun1194.instaclone.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val storyAdapter  = StoriesAdapter()
    private val feedAdapter  = FeedAdapter()
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,R.layout.activity_main)

        observeData()

    }

    private fun observeData() {
        viewModel.getUsers()
        viewModel.users.observe(this){
            when(it){
                is DataResponse.Error -> toast(it.error.message.toString())
                is DataResponse.Success -> {
                    storyAdapter.submitList(it.data)
                    feedAdapter.submitList(it.data)
                    binding.storiesList.adapter = storyAdapter
                    binding.feedList.adapter = feedAdapter

                }
            }
        }
    }


}