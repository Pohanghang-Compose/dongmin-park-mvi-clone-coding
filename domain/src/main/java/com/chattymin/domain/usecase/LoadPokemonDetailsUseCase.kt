package com.chattymin.domain.usecase

import com.chattymin.data.entity.PokemonDetails
import com.chattymin.data.repository.PokemonRepository

class LoadPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(id: Int): PokemonDetails? {
        return pokemonRepository.getById(id)
    }
}
