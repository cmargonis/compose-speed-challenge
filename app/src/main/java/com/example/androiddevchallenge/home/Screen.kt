/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import java.util.Locale

@Composable
fun HomeContent() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomBar(color = MaterialTheme.colors.background) },
            floatingActionButton = { Fab() },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
        ) {
        }
    }
}

@Composable
fun Fab() {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        onClick = { /*TODO*/ }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_play_arrow),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onPrimary),
            contentDescription = "Play",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun BottomBar(color: Color) {
    val insets = LocalWindowInsets.current
    Surface(elevation = 8.dp, color = color) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    bottom = with(LocalDensity.current) { insets.navigationBars.bottom.toDp() + 8.dp }
                )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_spa),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground),
                    contentDescription = "Home",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Home".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onBackground
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_account_circle),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground),
                    contentDescription = "Profile",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Profile".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        BottomBar(color = MaterialTheme.colors.background)
    }
}
