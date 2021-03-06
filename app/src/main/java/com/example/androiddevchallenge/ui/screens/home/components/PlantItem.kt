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
package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.ui.datasource.model.Plant
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PlantItem(
    modifier: Modifier = Modifier,
    plant: Plant
) {
    ConstraintLayout(
        constraintSet = constraints(),
        modifier = modifier.height(64.dp)
    ) {
        CoilImage(
            data = plant.image,
            contentDescription = "${plant.name}",
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .layoutId("image")
                .size(64.dp)
        )

        Text(
            plant.name,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .layoutId("title")
                .paddingFromBaseline(top = 24.dp),
        )

        Text(
            plant.description,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .layoutId("desc")
                .paddingFromBaseline(bottom = 24.dp)
        )
    }
}

private fun constraints(): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val title = createRefFor("title")
        val description = createRefFor("desc")

        constrain(image) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }

        constrain(title) {
            linkTo(start = image.end, end = parent.end, startMargin = 8.dp)
            width = Dimension.fillToConstraints
        }

        constrain(description) {
            linkTo(start = title.start, end = parent.end)
            top.linkTo(title.bottom)
            bottom.linkTo(parent.bottom)

            width = Dimension.fillToConstraints
        }
    }
}
