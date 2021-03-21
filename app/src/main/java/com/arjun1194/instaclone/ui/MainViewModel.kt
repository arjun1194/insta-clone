package com.arjun1194.instaclone.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun1194.instaclone.data.model.DataResponse
import com.arjun1194.instaclone.data.model.User
import com.arjun1194.instaclone.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val users = MutableLiveData<DataResponse<List<User>>>()


    fun getUsers() {
        viewModelScope.launch {
            userRepository.getUsers().onEach {
                users.postValue(it)
            }.launchIn(viewModelScope)
        }
    }

}