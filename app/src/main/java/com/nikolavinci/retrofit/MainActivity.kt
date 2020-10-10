package com.nikolavinci.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikolavinci.retrofit.adapter.MyAdapter
import com.nikolavinci.retrofit.model.Post
import com.nikolavinci.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

//        val myPost = Post(2,2,"nikolavinci", "Android Developer")
//        viewModel.pushPost2(2, 2, " nv", "ab")

//        viewModel.getCustomPosts(2, "id", "desc")
        viewModel.getPost("11112222")
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.headers().toString())
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerview() {
        RecyclerView.adapter = myAdapter
        RecyclerView.layoutManager = LinearLayoutManager(this)
    }

}