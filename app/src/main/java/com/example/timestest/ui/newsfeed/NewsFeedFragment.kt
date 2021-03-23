package com.example.timestest.ui.newsfeed

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.databinding.NewsfeedFragBinding
import com.example.timestest.ui.newsfeeditemdetail.NewsfeedItemDetailFragment
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
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshNewsfeed()
        }
        binding.newsFeedViewModel?.navigateToSelectedNewsfeedItem?.observe(viewLifecycleOwner, Observer {
            it?.let {
                navigateToNewsfeedItemDetail(it)
            }
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupListAdapter()
    }

    private fun setupListAdapter() {
        val viewModel = binding.newsFeedViewModel
        if (viewModel != null) {
            listAdapter = NewsfeedAdapter(viewModel, NewsfeedAdapter.OnClickListener {
                viewModel.displayNewsfeedItemDetail(it)
            })
            binding.newsfeedItemsList.adapter = listAdapter
        }
    }

    private fun navigateToNewsfeedItemDetail(item: NewsfeedItem) {
        val action = NewsFeedFragmentDirections.actionNewsFeedFragmentToNewsfeedItemDetailFragment(item)
        findNavController().navigate(action)

        viewModel.displayNewsfeedItemDetailComplete()
    }
}