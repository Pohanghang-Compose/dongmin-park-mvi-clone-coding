package com.chattymin.mviclonecoding.ui.components.organisms

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chattymin.data.entity.PokemonDetails
import com.chattymin.mviclonecoding.ui.sample.SAMPLE_POKEMON_DETAILS

@Composable
fun PokemonTwoCard(
    one: PokemonDetails? = null,
    onClickedOne: (() -> Unit)? = null,
    two: PokemonDetails? = null,
    onClickedTwo: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        if (one != null) {
            PokemonCard(
                pokemonDetails = one,
                onClick = { onClickedOne?.invoke() },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = 0.5f)
                    .padding(end = 4.dp),
            )
        }

        if (two != null) {
            PokemonCard(
                pokemonDetails = two,
                onClick = { onClickedTwo?.invoke() },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 4.dp),
            )
        }
    }
}

@Preview
@Composable
fun PokemonTwoCard_Preview() {
    PokemonTwoCard(
        one = SAMPLE_POKEMON_DETAILS,
        two = SAMPLE_POKEMON_DETAILS,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
    )
}

@Preview
@Composable
fun PokemonTwoCard_TwoNull_Preview() {
    PokemonTwoCard(
        one = SAMPLE_POKEMON_DETAILS,
        two = null,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
    )
}
