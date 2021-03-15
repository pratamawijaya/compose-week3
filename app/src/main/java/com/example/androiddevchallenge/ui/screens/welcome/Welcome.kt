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
package com.example.androiddevchallenge.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.ReverseTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun WelcomeScreen(onWelcomeCompleteListener: () -> Unit) {
    ScreenBackground {
        Column(
            modifier = Modifier
                .padding(top = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(start = 88.dp, bottom = 48.dp),
                painter = painterResource(id = R.drawable.ic_welcome_illos),
                contentDescription = "leaf",
                contentScale = ContentScale.Crop
            )

            Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "")
            Text(
                text = stringResource(R.string.welcome_subtitle),
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                style = MaterialTheme.typography.subtitle1
            )
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ReverseTheme {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .paddingFromBaseline(bottom = 8.dp)
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(text = stringResource(R.string.create_account))
                    }
                }
                TextButton(
                    onClick = onWelcomeCompleteListener,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp)
                ) {
                    val textColor = if (MaterialTheme.colors.isLight) pink900 else white
                    Text(text = stringResource(R.string.log_in), color = textColor)
                }
            }
        }
    }
}

@Composable
fun ScreenBackground(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxHeight(),
        color = MaterialTheme.colors.primary
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        content()
    }
}

@Preview("Light Theme")
@Composable
fun LightPreviewWelcome() {
    MyTheme {
        WelcomeScreen(onWelcomeCompleteListener = {})
    }
}

@Preview("Dark Theme")
@Composable
fun DarkPreviewWelcome() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(onWelcomeCompleteListener = { })
    }
}
