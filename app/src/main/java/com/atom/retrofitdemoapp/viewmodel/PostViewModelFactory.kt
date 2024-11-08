package com.atom.retrofitdemoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atom.retrofitdemoapp.data.repository.PostRepository

//class PostViewModelFactory(private val repository: PostRepository) : ViewModelProvider.Factory {
//
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(PostRepository::class.java)){
//            return PostViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown viewModel class")
//    }
//}
class PostViewModelFactory(
    private val repository: PostRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            PostViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}