package com.sach.paging3demo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.sach.paging3demo.paging.QuotePagingSource
import com.sach.paging3demo.quoteapi.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(val quoteApi: QuoteApi) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quoteApi)}
    ).liveData
}