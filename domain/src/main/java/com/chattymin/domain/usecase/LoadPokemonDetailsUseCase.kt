package com.chattymin.domain.usecase

class LoadPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(id: Int): PokemonDetails? {
        return pokemonRepository.getById(id)
    }
}
