package com.example.timestest.ui.newsfeeditemdetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.timestest.databinding.NewsfeedFragBinding
import com.example.timestest.databinding.NewsfeedItemDetailBinding
import com.example.timestest.ui.newsfeed.NewsFeedViewModel
import kotlinx.android.synthetic.main.activity_main.*

class NewsfeedItemDetailFragment: Fragment() {
    private lateinit var binding: NewsfeedItemDetailBinding
    private val viewModel by viewModels<NewsfeedItemDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsfeedItemDetailBinding.inflate(inflater, container, false).apply {
            newsFeedItemDetailViewModel = viewModel
        }
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }
}