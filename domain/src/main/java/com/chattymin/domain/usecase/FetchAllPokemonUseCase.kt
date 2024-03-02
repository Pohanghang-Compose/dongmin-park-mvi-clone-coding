package com.chattymin.domain.usecase

class FetchAllPokemonUseCase(
    private val pokemonRepository: PokemonRepository,
    private val configRepository: ConfigRepository
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
