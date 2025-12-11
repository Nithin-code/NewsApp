package com.example.newsapp.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapp.network.client.KtorClient
import com.example.newsapp.top_head_lines.repository.TopHeadLinesRepository
import com.example.newsapp.top_head_lines.repository.TopHeadLinesRepositoryImpl
import com.example.newsapp.top_head_lines.view_model.TopHeadLinesViewModel
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module




val topHeadLinesModule = module {
    single<TopHeadLinesRepository> { TopHeadLinesRepositoryImpl(get()) }
    single<HttpClient> { KtorClient.create() }
    viewModelOf(::TopHeadLinesViewModel)
}