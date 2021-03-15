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
package com.example.androiddevchallenge.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.datasource.PlantDataSource
import com.example.androiddevchallenge.ui.datasource.ThemeDataSource
import com.example.androiddevchallenge.ui.datasource.model.Theme
import com.example.androiddevchallenge.ui.screens.home.components.BloomCard
import com.example.androiddevchallenge.ui.screens.home.components.PlantItem
import com.example.androiddevchallenge.ui.screens.home.components.SearchField
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxHeight(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        LazyColumn {
            item {
                SearchField()
            }

            item {
                // browse theme
                Text(
                    text = "Browse themes",
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp)
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )
            }

            item {

                // horizontal list
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(ThemeDataSource.themes) { theme ->
                        CardItem(theme = theme)
                    }
                }

            }

            item {
                // header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 40.dp)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Design your home garden",
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onBackground
                    )
                    Icon(
                        imageVector = Icons.Filled.FilterList,
                        contentDescription = "filter icon"
                    )
                }
            }

            items(PlantDataSource.plants) { plant ->
                PlantItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    plant = plant
                )
            }

        }
    }
}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    theme: Theme
) {
    BloomCard(
        modifier = modifier
            .size(136.dp)
            .clickable { }
    ) {
        Column(Modifier.fillMaxSize()) {
            CoilImage(
                data = theme.image,
                contentScale = ContentScale.Crop,
                contentDescription = "Theme: ${theme.name}",
                fadeIn = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = theme.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
