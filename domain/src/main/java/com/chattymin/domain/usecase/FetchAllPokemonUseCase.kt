package com.chattymin.domain.usecase

import com.chattymin.data.repository.ConfigRepository
import com.chattymin.data.repository.PokemonRepository

class FetchAllPokemonUseCase(
    private val pokemonRepository: PokemonRepository,
    private val configRepository: ConfigRepository,
) {
    suspend operator fun invoke(): Boolean {
        return if (!configRepository.createdDatabase) {
            pokemonRepository.clear()
            pokemonRepository.fetch().apply { configRepository.createdDatabase = this }
        } else {
            true
        }
    }
}
