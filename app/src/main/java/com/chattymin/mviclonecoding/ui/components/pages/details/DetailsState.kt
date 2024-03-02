package com.chattymin.mviclonecoding.ui.components.pages.details


data class DetailsState(
    val status: UiStatus = UiStatus.Loading,
    val details: PokemonDetails? = null,
    val evolutions: List<PokemonDetails> = emptyList()
)
