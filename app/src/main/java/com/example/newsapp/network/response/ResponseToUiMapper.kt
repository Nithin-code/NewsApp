package com.example.newsapp.network.response

import android.view.translation.TranslationSpec
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
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
fun <T, E> NetworkResponse<T, E>.OnResponseReceived(
    onLoading: @Composable () -> Unit,
    onSuccess: @Composable (T) -> Unit,
    onError: @Composable (String) -> Unit,
    animeSpec: ContentTransform = slideInHorizontally(tween(durationMillis = 400))
            togetherWith slideOutHorizontally(tween(durationMillis = 400))
) {

    val networkResponse = this

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {

            AnimatedContent(
                transitionSpec = {
                    animeSpec
                },
                targetState = networkResponse
            ) { state ->

                when (state) {
                    is NetworkResponse.Error -> {
                        onError.invoke(state.getErrorMessage())
                    }

                    NetworkResponse.Loading -> {
                        onLoading.invoke()
                    }

                    is NetworkResponse.Success -> {
                        onSuccess.invoke(state.getSuccessData())
                    }
                }

            }

        }

    }

}