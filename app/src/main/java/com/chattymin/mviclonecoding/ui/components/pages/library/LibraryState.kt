package com.chattymin.mviclonecoding.ui.components.pages.library

import com.chattymin.data.entity.PokemonDetails
import com.chattymin.mviclonecoding.ui.common.UiStatus

data class LibraryState(
    val status: UiStatus = UiStatus.Loading,
    val searchText: String = "",
    val detailsList: List<PokemonDetails> = emptyList(),
)
