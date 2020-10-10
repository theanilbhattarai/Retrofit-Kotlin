package com.nikolavinci.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolavinci.retrofit.model.Post
import com.nikolavinci.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response: Response<Post> = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response: Response<Post> = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }

    fun getPost(auth: String) {
        viewModelScope.launch {
            val response: Response<Post> = repository.getPost(auth)
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response: Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPosts.value = response
        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, options)
            myCustomPosts2.value = response
        }
    }

}