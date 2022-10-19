package com.dev.tiktok_compose.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.tiktok_compose.data.dummy.GenerateDummy
import com.dev.tiktok_compose.data.model.Feed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _feeds = MutableStateFlow<List<Feed>>(emptyList())
    val feeds: StateFlow<List<Feed>>
        get() = _feeds

    init {
        viewModelScope.launch {
            _feeds.value = GenerateDummy.listOfFeed()
        }
    }
}