package com.example.newsapp.top_head_lines.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.newsapp.components.FullPageErrorPage
import com.example.newsapp.components.FullPageLoadingScreen
import com.example.newsapp.navigation.Screens
import com.example.newsapp.network.client.KtorClient
import com.example.newsapp.network.response.NetworkResponse
import com.example.newsapp.top_head_lines.data.HeadLinesData
import com.example.newsapp.top_head_lines.repository.TopHeadLinesRepositoryImpl
import com.example.newsapp.top_head_lines.view_model.TopHeadLinesViewModel
import io.ktor.client.HttpClient

@Composable
fun TopHeadLinesScreen(
    modifier: Modifier = Modifier
){

    val viewModel = remember {
        TopHeadLinesViewModel(TopHeadLinesRepositoryImpl(KtorClient.create()))
    }

    val uiState = viewModel.headLinesDataUIState.collectAsState()

    when(uiState.value){
        is NetworkResponse.Error -> {
            FullPageErrorPage(
                errorMessage = uiState.value.getErrorMessage()
            )
        }
        is NetworkResponse.Loading -> {
            FullPageLoadingScreen()
        }
        is NetworkResponse.Success -> {
            TopHeadLinesScreenContent(
                data = uiState.value.getSuccessData()
            )
        }
    }

}

@Composable
fun TopHeadLinesScreenContent(
    data: HeadLinesData
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
    ) {

        itemsIndexed(data.articles){ index, item ->

            TopHeadLinesCard(
                title = item.title,
                description = item.description.toString(),
                imageUrl = item.urlToImage.toString(),
                source = ""
            )
        }

    }

}

@Composable
fun TopHeadLinesCard(
    modifier: Modifier = Modifier,
    imageUrl : String,
    title : String,
    description : String,
    source : String
){
    Surface {

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {

            AsyncImage(
                model = imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = title,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = source,
                fontSize = 14.sp
            )

        }

    }

}