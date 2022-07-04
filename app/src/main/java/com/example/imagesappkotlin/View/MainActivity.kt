package com.example.imagesappkotlin.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagesapp.Model.API.RetrofitService
import com.example.imagesapp.ViewModel.MainViewModel
import com.example.imagesappkotlin.ImagesAdapter
import com.example.imagesappkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    lateinit var recyclerAdapter: ImagesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recView.layoutManager = GridLayoutManager(this, 2)
        recyclerAdapter = ImagesAdapter(this, this)
        recView.adapter = recyclerAdapter



        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, {
            if (it != null) {
                recyclerAdapter.setMovieList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting List!!", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeAPICall()

    }
}