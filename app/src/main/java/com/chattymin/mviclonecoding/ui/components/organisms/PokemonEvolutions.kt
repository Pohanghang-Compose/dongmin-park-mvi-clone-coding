package com.chattymin.mviclonecoding.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chattymin.data.entity.PokemonDetails
import com.chattymin.mviclonecoding.R
import com.chattymin.mviclonecoding.ui.sample.SAMPLE_POKEMON_DETAILS_LIST

@Composable
fun PokemonEvolutions(details: List<PokemonDetails>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.evolution_title),
            style = MaterialTheme.typography.h5,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            details.forEach {
                PokemonEvolution(details = it)

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PokemonEvolutions_Preview() {
    PokemonEvolutions(SAMPLE_POKEMON_DETAILS_LIST)
}
