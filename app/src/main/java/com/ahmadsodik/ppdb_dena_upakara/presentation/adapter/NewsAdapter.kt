package com.ahmadsodik.ppdb_dena_upakara.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmadsodik.ppdb_dena_upakara.databinding.ItemNewsBinding
import com.ahmadsodik.ppdb_dena_upakara.domain.model.News
import com.ahmadsodik.ppdb_dena_upakara.utils.Extensions.showImageInto

class NewsAdapter: ListAdapter<News,NewsAdapter.NewsViewHolder>(DIFF_CALLBACK) {
    inner class NewsViewHolder(private val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News){
            binding.apply {
                ivNews.showImageInto(itemView.context,news.imageUrl)
                tvTitle.text = news.title
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}