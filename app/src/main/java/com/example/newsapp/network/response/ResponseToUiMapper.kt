package com.example.newsapp.network.response

import android.view.translation.TranslationSpec
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun<T,E> NetworkResponse<T,E>.OnResponseReceived(
    onLoading : @Composable () -> Unit,
    onSuccess : @Composable () -> Unit,
    onError : @Composable () -> Unit,
    animeSpec : TranslationSpec = EnterTransition()
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ){

            AnimatedContent(this) {

            }

        }

    }

}