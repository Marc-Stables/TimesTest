package com.example.timestest.ui.newsfeed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.timestest.databinding.NewsfeedFragBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFeedFragment: Fragment() {
    private lateinit var binding: NewsfeedFragBinding
    private val viewModel by viewModels<NewsFeedViewModel>()
    private lateinit var listAdapter: NewsfeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsfeedFragBinding.inflate(inflater, container, false).apply {
            newsFeedViewModel = viewModel
        }
        binding.lifecycleOwner = this
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.newsfeedRefreshed()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListAdapter()
    }

    private fun setupListAdapter() {
        val viewModel = binding.newsFeedViewModel
        if (viewModel != null) {
            listAdapter = NewsfeedAdapter(viewModel)
            binding.newsfeedItemsList.adapter = listAdapter
        }
    }
}