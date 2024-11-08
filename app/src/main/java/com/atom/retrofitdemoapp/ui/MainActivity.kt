package com.atom.retrofitdemoapp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.atom.retrofitdemoapp.R
import com.atom.retrofitdemoapp.data.api.RetrofitInstance
import com.atom.retrofitdemoapp.data.repository.PostRepository
import com.atom.retrofitdemoapp.databinding.ActivityMainBinding
import com.atom.retrofitdemoapp.model.PostDto
import com.atom.retrofitdemoapp.viewmodel.PostViewModel
import com.atom.retrofitdemoapp.viewmodel.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel : PostViewModel by viewModels {
        PostViewModelFactory(PostRepository(RetrofitInstance.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        viewModel.posts.observe(this){ posts ->
            Log.d("MainActivity", "Posts : $posts")
        }

        viewModel.post.observe(this){post ->
            Log.d("MainActivity", "Posts : $post")

        }

        viewModel.operationStatus.observe(this){status->
            Log.d("MainActivity", "Status : $status")
        }


//        viewModel.getPost(1)
//        viewModel.deletePost(1)

        viewModel.createPost(PostDto(101, 102,"hello", "hello body"))
        viewModel.getPosts()



    }
}