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
package com.example.androiddevchallenge.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import java.util.Locale

@Composable
fun LoginContent(loginListener: (() -> Unit) = {}) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_login),
                contentDescription = "Login",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Log in".toUpperCase(Locale.getDefault()),
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )

                var email: String by remember { mutableStateOf("") }
                var password: String by remember { mutableStateOf("") }
                val focusRequester = remember { FocusRequester() }
                val focusManager = LocalFocusManager.current

                TextField(
                    value = email,
                    placeholder = {
                        Text(text = "Email address", style = MaterialTheme.typography.body1)
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    textStyle = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onSurface
                    ),
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    singleLine = true,
                    onValueChange = { newValue ->
                        email = newValue
                    },
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusRequester.requestFocus()
                        }
                    )
                )

                TextField(
                    value = password,
                    placeholder = {
                        Text(text = "Password", style = MaterialTheme.typography.body1)
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    textStyle = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.onSurface
                    ),
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .focusRequester(focusRequester),
                    singleLine = true,
                    onValueChange = { newValue ->
                        password = newValue
                    },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Button(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    shape = MaterialTheme.shapes.medium,
                    onClick = loginListener
                ) {
                    Text(
                        text = "log in".toUpperCase(Locale.getDefault()),
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
                    )
                }

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.onBackground,
                                fontStyle = MaterialTheme.typography.body1.fontStyle,
                                fontSize = MaterialTheme.typography.body1.fontSize,
                                fontFamily = MaterialTheme.typography.body1.fontFamily,
                                fontWeight = MaterialTheme.typography.body1.fontWeight,
                                letterSpacing = MaterialTheme.typography.body1.letterSpacing
                            )
                        ) {
                            append("Don't have an account? ")
                        }

                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.onBackground,
                                fontStyle = MaterialTheme.typography.body1.fontStyle,
                                fontSize = MaterialTheme.typography.body1.fontSize,
                                fontFamily = MaterialTheme.typography.body1.fontFamily,
                                fontWeight = MaterialTheme.typography.body1.fontWeight,
                                letterSpacing = MaterialTheme.typography.body1.letterSpacing,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("Sign up")
                        }
                    },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .wrapContentSize()
                )
            }
        }
    }
}
