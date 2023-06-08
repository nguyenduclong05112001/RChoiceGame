package com.longhrk.app.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.longhrk.app.component.PhotoItem
import com.longhrk.app.core.GetDimension
import com.longhrk.app.ui.theme.background
import com.longhrk.app.ui.theme.border
import com.longhrk.app.ui.theme.component
import com.longhrk.app.ui.viewmodel.GameViewModel
import com.longhrk.app.ui.viewmodel.model.Animal
import com.longhrk.app.ui.viewmodel.model.Level
import com.longhrk.data.init.photoRes
import com.longhrk.dimension.R as resDimension

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(gameViewModel: GameViewModel) {

    val currentChallenge by gameViewModel.currentChallenge.collectAsState()

    val animals by remember {
        mutableStateOf(currentChallenge?.animal ?: ArrayList<Animal>())
    }

    val challenge = createChallenge(Level.Easy)
    val listIndex = mutableListOf(
        0, 1, 2,
        3, 4, 5
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(
                    vertical = GetDimension.dimensionOfDp(res = resDimension.dimen._10sdp),
                    horizontal = GetDimension.dimensionOfDp(res = resDimension.dimen._20sdp)
                )
                .fillMaxWidth(),
            cells = GridCells.Adaptive(GetDimension.dimensionOfDp(res = resDimension.dimen._50sdp)),
        ) {
            items(challenge) {
                PhotoItem(
                    modifier = Modifier
                        .padding(GetDimension.dimensionOfDp(res = resDimension.dimen._10sdp))
                        .size(GetDimension.dimensionOfDp(res = resDimension.dimen._50sdp)),
                    animal = it
                )
            }
        }

        LazyVerticalGrid(
            modifier = Modifier
                .padding(
                    vertical = GetDimension.dimensionOfDp(res = resDimension.dimen._10sdp),
                    horizontal = GetDimension.dimensionOfDp(res = resDimension.dimen._20sdp)
                ),
            cells = GridCells.Fixed(3),
        ) {
            itemsIndexed(listIndex) { index, element ->
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(component)
                    .border(
                        width = 1.dp,
                        color = border
                    )
                )
            }
        }
    }
}

private fun createChallenge(level: Level): List<Animal> {
    val listPhoto = photoRes.subList(5, 15)
    val listindex = when (level) {
        Level.Easy -> {
            mutableListOf(
                0, 1, 2,
                3, 4, 5
            )
        }
        Level.Normal -> {
            mutableListOf(
                0, 1, 2,
                3, 4, 5,
                6, 7, 8
            )
        }
        Level.Difficult -> {
            mutableListOf(
                0, 1, 2,
                3, 4, 5,
                6, 7, 8,
                9, 10, 11
            )
        }
    }

    val items = when (level) {
        Level.Easy -> 4
        Level.Normal -> 3
        Level.Difficult -> 5
    }

    val animals = ArrayList<Animal>()

    for (i in 0 until items) {
        animals.add(
            Animal(
                index = listindex.random().apply {
                    listindex.remove(this)
                },
                photo = listPhoto.random().apply {
                    listPhoto.remove(this)
                },
            )
        )
    }

    return animals
}