package com.example.timestest.ui.newsfeeditemdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.timestest.data.model.NewsfeedItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsfeedItemDetailViewModel @Inject constructor(
    state: SavedStateHandle
): ViewModel() {
    val item: NewsfeedItem? = state.get<NewsfeedItem>("newsfeedItem")
}
