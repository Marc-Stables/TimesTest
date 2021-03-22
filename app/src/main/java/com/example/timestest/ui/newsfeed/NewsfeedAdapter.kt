package com.example.timestest.ui.newsfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.databinding.NewsfeedItemBinding

class NewsfeedAdapter(private val viewModel: NewsFeedViewModel): ListAdapter<NewsfeedItem, NewsfeedAdapter.ViewHolder>(
    NewsfeedItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }

    class ViewHolder private constructor(val binding: NewsfeedItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: NewsFeedViewModel, item: NewsfeedItem) {
            binding.newsfeedViewModel = viewModel
            binding.newsfeedItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NewsfeedItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class NewsfeedItemDiffCallback : DiffUtil.ItemCallback<NewsfeedItem>() {
    override fun areItemsTheSame(oldItem: NewsfeedItem, newItem: NewsfeedItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsfeedItem, newItem: NewsfeedItem): Boolean {
        return oldItem == newItem
    }
}
