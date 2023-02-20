package com.sach.paging3demo.quoteapi

import com.sach.paging3demo.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page : Int): QuoteList
}