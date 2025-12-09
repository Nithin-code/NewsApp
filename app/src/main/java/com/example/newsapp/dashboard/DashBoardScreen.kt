package com.example.newsapp.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsapp.ui.theme.PrimaryBlue
import org.w3c.dom.Text

@Composable
fun DashBoardScreen(
    modifier: Modifier = Modifier,
    onItemClicked: () -> Unit
){

    val dashBoardItems = remember {
        listOf("Top HeadLines",
            "News Scores",
            "Countries",
            "Languages",
            "Search"
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        itemsIndexed(dashBoardItems){ index, item ->

            DashBoardItem(
                text = item,
                onItemClicked = {
                    onItemClicked.invoke()
                }
            )

        }

    }

}

@Composable
fun DashBoardItem(
    modifier: Modifier = Modifier,
    text: String,
    onItemClicked : () -> Unit
){

    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = PrimaryBlue,
        onClick = onItemClicked
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,

            )
    }

}