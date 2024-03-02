package com.chattymin.mviclonecoding.ui.components.organisms

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chattymin.mviclonecoding.ui.components.molecules.SmallCard

@Composable
fun PokemonWeight(weight: String, modifier: Modifier = Modifier) {
    SmallCard(text = "Weight : $weight", modifier = modifier)
}

@Preview
@Composable
private fun PokemonWeight_Preview() {
    PokemonWeight(
        weight = "19.65KG",
        modifier = Modifier.wrapContentSize(),
    )
}
