package com.sach.paging3demo.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.sach.paging3demo.db.QuoteDatabase
import com.sach.paging3demo.paging.QuotePagingSource
import com.sach.paging3demo.paging.QuoteRemoteMediator
import com.sach.paging3demo.quoteapi.QuoteApi
import javax.inject.Inject

@ExperimentalPagingApi
class QuoteRepository @Inject constructor(
    private val quoteApi: QuoteApi,
    private val quoteDatabase: QuoteDatabase,
) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        remoteMediator = QuoteRemoteMediator(quoteApi, quoteDatabase),
        pagingSourceFactory = { quoteDatabase.quoteDao().getQuotes()}
    ).liveData
}