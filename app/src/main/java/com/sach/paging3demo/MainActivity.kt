package com.sach.paging3demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.sach.paging3demo.adapter.LoaderAdapter
import com.sach.paging3demo.adapter.QuotePagingAdapter
import com.sach.paging3demo.databinding.ActivityMainBinding
import com.sach.paging3demo.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalPagingApi
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuoteViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = QuotePagingAdapter()
        viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]

        binding.quoteList.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter.withLoadStateHeaderAndFooter(
                header = LoaderAdapter(),
                footer = LoaderAdapter()
            )
        }

        viewModel.list.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}