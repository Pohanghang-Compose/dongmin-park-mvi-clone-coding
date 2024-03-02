package com.chattymin.domain.usecase

import com.chattymin.data.entity.PokemonDetails
import com.chattymin.data.repository.PokemonRepository

class SearchPokemonFromNameUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(searchText: String): List<PokemonDetails> {
        return if (searchText.isEmpty()) {
            pokemonRepository.getAll()
        } else {
            pokemonRepository.getAll().filter { it.pokemon.name.contains(searchText) }
        }
    }
}
