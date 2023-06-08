package com.longhrk.app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.longhrk.app.ui.viewmodel.model.Animal

@Composable
fun PhotoItem(
    modifier: Modifier,
    animal: Animal
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = animal.photo),
            contentDescription = null
        )
    }
}