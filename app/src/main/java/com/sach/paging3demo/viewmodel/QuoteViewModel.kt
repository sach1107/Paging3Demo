package com.sach.paging3demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.sach.paging3demo.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
@ExperimentalPagingApi
class QuoteViewModel @Inject constructor(repository: QuoteRepository): ViewModel() {

    val list = repository.getQuotes().cachedIn(viewModelScope)

}