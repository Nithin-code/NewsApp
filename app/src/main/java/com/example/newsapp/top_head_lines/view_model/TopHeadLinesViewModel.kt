package com.example.newsapp.top_head_lines.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.mappers.toHeadLinesUIState
import com.example.newsapp.network.response.DataError
import com.example.newsapp.network.response.NetworkResponse
import com.example.newsapp.top_head_lines.data.HeadLinesData
import com.example.newsapp.top_head_lines.repository.TopHeadLinesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopHeadLinesViewModel(
    val topHeadLinesRepository: TopHeadLinesRepository
) : ViewModel() {

    private val _headLinesUIState : MutableStateFlow<NetworkResponse<HeadLinesData, DataError>> = MutableStateFlow(NetworkResponse.Loading)

    val headLinesDataUIState = _headLinesUIState

    init {
        getTopHeadLines()
    }


    fun getTopHeadLines() {
        viewModelScope.launch {
            val response = topHeadLinesRepository.getTopHeadLines()
            _headLinesUIState.update {
                response
            }
        }
    }

}

data class HeadLinesUIScreenState(
    val headLinesData: HeadLinesData
)