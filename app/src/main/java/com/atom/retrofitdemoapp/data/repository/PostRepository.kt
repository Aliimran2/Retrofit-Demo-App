package com.atom.retrofitdemoapp.data.repository

import com.atom.retrofitdemoapp.data.api.PostApi
import com.atom.retrofitdemoapp.model.PostDto

class PostRepository(private val api : PostApi) {

    suspend fun getPosts() = api.getPosts()

    suspend fun getPost(id:Int) = api.getPost(id)

    suspend fun createPost(post: PostDto) = api.createPost(post)

    suspend fun updatePost(id: Int, post: PostDto) = api.updatePost(id, post)

    suspend fun deletePost(id: Int) = api.deletePost(id)
}