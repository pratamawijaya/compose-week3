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
package com.example.androiddevchallenge.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.MyThemeSecondary

@Composable
fun LoginScreen(loginSuccessListener: () -> Unit) {
    var emailAddress by mutableStateOf("")
    var password by mutableStateOf("")

    Surface(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyThemeSecondary {
                Text(
                    text = "Log in with email",
                    modifier = Modifier.paddingFromBaseline(top = 184.dp),
                    style = MaterialTheme.typography.h1
                )
                OutlinedTextField(
                    value = emailAddress,
                    modifier = Modifier.fillMaxWidth(),

                    onValueChange = { emailAddress = it },
                    placeholder = {
                        Text(text = "Email Address", style = MaterialTheme.typography.body1)
                    },
                    label = { Text(text = "Email") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Password") },
                    placeholder = {
                        Text(
                            text = "12334444",
                            style = MaterialTheme.typography.body1
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = {
                        password = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Text(
                    buildAnnotatedString {
                        append("By clicking below, you agree to our ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Terms of Use")
                        }
                        append(" and consent to our ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Privacy Policy")
                        }
                        append(".")
                    },
                    modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = loginSuccessListener,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .paddingFromBaseline(bottom = 8.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = stringResource(R.string.log_in))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    MyTheme {
        LoginScreen(loginSuccessListener = { /*TODO*/ })
    }
}
