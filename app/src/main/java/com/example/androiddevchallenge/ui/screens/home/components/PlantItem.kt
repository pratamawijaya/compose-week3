package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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