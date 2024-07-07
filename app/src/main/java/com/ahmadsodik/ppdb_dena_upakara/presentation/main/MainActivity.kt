package com.ahmadsodik.ppdb_dena_upakara.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadsodik.ppdb_dena_upakara.data.local.DummyData
import com.ahmadsodik.ppdb_dena_upakara.databinding.ActivityMainBinding
import com.ahmadsodik.ppdb_dena_upakara.presentation.adapter.NewsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val newsData = DummyData.newsData
        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        newsAdapter.submitList(newsData)
    }
}