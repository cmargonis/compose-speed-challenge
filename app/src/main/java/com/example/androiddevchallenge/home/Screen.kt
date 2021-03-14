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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.widgets.Avatar
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
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
            val insets = LocalWindowInsets.current
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = with(LocalDensity.current) { insets.statusBars.top.toDp() + 16.dp })
            ) {

                var searchValue: String by remember { mutableStateOf("") }
                val focusManager = LocalFocusManager.current

                TextField(
                    value = searchValue,
                    placeholder = {
                        Text(text = "Search", style = MaterialTheme.typography.body1)
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    textStyle = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onSurface
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    singleLine = true,
                    onValueChange = { newValue ->
                        searchValue = newValue
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search Icon",
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface),
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Text(
                    text = "favorite collections".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 16.dp, top = 24.dp)
                )

                AlignYourBody()

                Text(
                    text = "Align your mind".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 16.dp, top = 24.dp)
                )
            }
        }
    }
}

@Composable
private fun AlignYourBody() {
    Text(
        text = "Align your body".toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 16.dp, top = 24.dp)
    )
    LazyRow(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            Spacer(modifier = Modifier.width(8.dp))
        }
        items(bodyItems) { item ->
            Avatar(image = item.image, title = item.title)
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
fun HomePreview() {
    MyTheme {
        ProvideWindowInsets(consumeWindowInsets = true) {
            HomeContent()
        }
    }
}
