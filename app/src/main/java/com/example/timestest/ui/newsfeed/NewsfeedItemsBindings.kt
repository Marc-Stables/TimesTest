package com.example.timestest.ui.newsfeed

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timestest.data.model.NewsfeedItem

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<NewsfeedItem>?) {
    items?.let {
        (listView.adapter as NewsfeedAdapter).submitList(items)
    }
}