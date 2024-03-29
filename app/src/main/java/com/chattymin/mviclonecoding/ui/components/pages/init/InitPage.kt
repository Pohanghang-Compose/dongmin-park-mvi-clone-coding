package com.chattymin.mviclonecoding.ui.components.pages.init

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chattymin.mviclonecoding.ui.common.UiStatus
import com.chattymin.mviclonecoding.ui.components.organisms.DownloadRetryMessage
import com.chattymin.mviclonecoding.ui.components.organisms.DownloadingMessage

@Composable
fun InitPage(
    state: InitState,
    onRetry: () -> Unit,
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            when (state.status) {
                UiStatus.Loading -> {
                    DownloadingMessage(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center),
                    )
                }

                is UiStatus.Failed -> {
                    DownloadRetryMessage(
                        onRetry = { onRetry() },
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center),
                    )
                }

                UiStatus.Success -> Unit
                null -> Unit
            }
        }
    }
}
