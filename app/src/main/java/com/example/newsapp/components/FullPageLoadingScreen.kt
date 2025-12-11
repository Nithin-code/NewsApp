package com.example.newsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.PrimaryBlue

@Composable
fun FullPageLoadingScreen(
    modifier: Modifier = Modifier,
    loadingText : String = "Loading..."
){

    Row(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CircularProgressIndicator(
            modifier = Modifier
                .size(28.dp),
            color = PrimaryBlue
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = loadingText,
            fontSize = 18.sp
        )

    }

}

@Composable
@Preview(showBackground = true)
fun Prev(){
    FullPageLoadingScreen()
}