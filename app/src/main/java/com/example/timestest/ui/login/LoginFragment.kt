package com.example.timestest.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.timestest.R
import com.example.timestest.databinding.LoginFragBinding

class LoginFragment: Fragment() {
    private lateinit var binding: LoginFragBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.login_frag, container, false)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupNavigation()
    }

    private fun setupNavigation() {
        viewModel.loggedInEvent.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.i("LoginFragment", "Navigating to Feed screen")

                val action = LoginFragmentDirections.actionLoginFragmentToNewsFeedFragment(it.first, it.second)
                findNavController().navigate(action)

                viewModel.loginComplete()
            }
        })
    }
}