package com.sach.paging3demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sach.paging3demo.adapter.QuotePagingAdapter
import com.sach.paging3demo.databinding.ActivityMainBinding
import com.sach.paging3demo.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            this.adapter = adapter
        }

        viewModel.list.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}