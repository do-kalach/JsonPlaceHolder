package com.example.jsonplaceholder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholder.NetworkResult
import com.example.jsonplaceholder.api.Api
import com.example.jsonplaceholder.model.Comment
import com.example.jsonplaceholder.model.Post
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val api: Api) : ViewModel() {

    private val _getPosts: MutableLiveData<NetworkResult<List<Post>>> =
        MutableLiveData(NetworkResult.Loading)

    val getPosts: LiveData<NetworkResult<List<Post>>>
        get() = _getPosts

    private val _getComments: MutableLiveData<NetworkResult<List<Comment>>> =
        MutableLiveData(NetworkResult.Loading)

    val getComments: LiveData<NetworkResult<List<Comment>>>
        get() = _getComments

    fun getPosts() {
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            _getPosts.postValue(NetworkResult.Throw(throwable))
        }
        viewModelScope.launch(exception) {
            _getPosts.postValue(NetworkResult.Loading)
            delay(3000)
            if (api.getPosts().isSuccessful)
                _getPosts.postValue(NetworkResult.Success(api.getPosts().body()!!))
            else _getPosts.postValue(NetworkResult.Error(api.getPosts().code()))
        }
    }

    fun getPosts(parameters: Map<String, String>) {
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            _getPosts.postValue(NetworkResult.Throw(throwable))
        }
        viewModelScope.launch(exception) {
            _getPosts.postValue(NetworkResult.Loading)
            delay(3000)
            if (api.getPosts(parameters).isSuccessful)
                _getPosts.postValue(NetworkResult.Success(api.getPosts(parameters).body()!!))
            else _getPosts.postValue(NetworkResult.Error(api.getPosts(parameters).code()))
        }
    }

    fun getPosts(userId: Int, sort: String, order: String) {
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            _getPosts.postValue(NetworkResult.Throw(throwable))
        }
        viewModelScope.launch(exception) {
            _getPosts.postValue(NetworkResult.Loading)
            delay(3000)
            if (api.getPosts(userId, sort, order).isSuccessful)
                _getPosts.postValue(
                    NetworkResult.Success(
                        api.getPosts(userId, sort, order).body()!!
                    )
                )
            else _getPosts.postValue(NetworkResult.Error(api.getPosts(userId, sort, order).code()))
        }
    }

    fun getComments() {
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            _getComments.postValue(NetworkResult.Throw(throwable))
        }
        viewModelScope.launch(exception) {
            _getComments.postValue(NetworkResult.Loading)
            delay(3000)
            if (api.getComments(1).isSuccessful)
                _getComments.postValue(
                    NetworkResult.Success(
                        api.getComments(1).body()!!
                    )
                )
            else _getComments.postValue(NetworkResult.Error(api.getComments(1).code()))
        }
    }

    fun getComments(url: String) {
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            _getComments.postValue(NetworkResult.Throw(throwable))
        }
        viewModelScope.launch(exception) {
            _getComments.postValue(NetworkResult.Loading)
            delay(3000)
            if (api.getComments(url).isSuccessful)
                _getComments.postValue(
                    NetworkResult.Success(
                        api.getComments(url).body()!!
                    )
                )
            else _getComments.postValue(NetworkResult.Error(api.getComments(url).code()))
        }
    }
}


//    fun deletePost() {
//        viewModelScope.launch {
//            jsonPlaceHolderApi.deletePost(5)
//        }
//    call.enqueue(
//    object : Callback<Nothing> {
//        override fun onResponse(call: Call<Nothing>, response: Response<Nothing>) {
//            binding.textViewResult.text = "Code: " + response.code()
//        }
//
//        override fun onFailure(call: Call<Nothing>, t: Throwable) {
//            binding.textViewResult.text = t.message
//        }
//    })