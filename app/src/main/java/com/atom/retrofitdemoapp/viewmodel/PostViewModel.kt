package com.atom.retrofitdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.retrofitdemoapp.data.repository.PostRepository
import com.atom.retrofitdemoapp.model.PostDto
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository):ViewModel() {

    private val _posts = MutableLiveData<List<PostDto>>()
    val posts get() : LiveData<List<PostDto>> = _posts

    private val _post = MutableLiveData<PostDto>()
    val post get() : LiveData<PostDto> = _post

    private val _operationStatus = MutableLiveData<String>()
    val operationStatus: LiveData<String> get() = _operationStatus


    fun getPosts() = viewModelScope.launch {
        try {
            _posts.value = repository.getPosts()
            _operationStatus.value = "Posts fetched successfully"
        } catch (e: Exception) {
            _operationStatus.value = "Failed to fetch posts : ${e.message}"
        }
    }

    fun getPost(id:Int) = viewModelScope.launch {
        try {
            _post.value = repository.getPost(id)
            _operationStatus.value = "Post fetched successfully"
        }catch (e: Exception){
            _operationStatus.value = "Failed to fetch post: ${e.message}"
        }
    }

    fun createPost(post: PostDto) = viewModelScope.launch {
        try {
            val createdPost = repository.createPost(post)
            _post.value = createdPost
            _operationStatus.value = "Post created successfully"
        } catch (e: Exception){
            _operationStatus.value = "Failed to create post : ${e.message}"
        }
    }

    fun updatePost(id: Int, post: PostDto) = viewModelScope.launch {
        try {
            val updatedPost = repository.updatePost(id, post)
            _post.value = updatedPost
            _operationStatus.value = "Post updated successfully"
        } catch (e:Exception){
            _operationStatus.value = "Failed to updated : ${e.message}"
        }
    }

    fun deletePost(id: Int) = viewModelScope.launch {
        try {
            repository.deletePost(id)
            _operationStatus.value = "Post deleted successfully"
        }catch (e:Exception){
            _operationStatus.value = "Failed to delete the post : ${e.message}"
        }
    }
}