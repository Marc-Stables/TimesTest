package com.example.timestest.ui.newsfeed

import android.util.Log
import androidx.lifecycle.*
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.data.source.NewsfeedRepository
import com.example.timestest.databinding.NewsfeedFragBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    private val repo: NewsfeedRepository,
    private val state: SavedStateHandle
): ViewModel() {
    private lateinit var viewDataBinding: NewsfeedFragBinding

    private val _refreshing = MutableLiveData<Boolean>(false)
    val refreshing = _refreshing

    private val _newsfeedItems: LiveData<List<NewsfeedItem>> = repo.observeNewsfeedItems()
    val newsfeedItems = _newsfeedItems

    private val _navigateToSelectedNewsfeedItem = MutableLiveData<NewsfeedItem?>()
    val navigateToSelectedNewsfeedItem = _navigateToSelectedNewsfeedItem

    val username = state.get<String>("username")

    init {
        Log.i("NewsfeedViewModel", "NewsfeedViewModel initialised!")

        _refreshing.value = true
        refreshNewsfeed()
    }

    fun refreshNewsfeed() {
        viewModelScope.launch {
            repo.getNewsfeedItems(true)
            _refreshing.value = false
        }
    }

    fun displayNewsfeedItemDetail(item: NewsfeedItem) {
        _navigateToSelectedNewsfeedItem.value = item
    }

    fun displayNewsfeedItemDetailComplete() {
        _navigateToSelectedNewsfeedItem.value = null
    }
}