package com.chattymin.mviclonecoding.ui.components.pages.details

import com.chattymin.data.entity.PokemonDetails
import com.chattymin.mviclonecoding.ui.common.UiStatus

data class DetailsState(
    val status: UiStatus = UiStatus.Loading,
    val details: PokemonDetails? = null,
    val evolutions: List<PokemonDetails> = emptyList(),
)
