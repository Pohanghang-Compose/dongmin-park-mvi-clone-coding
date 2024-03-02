package com.chattymin.domain

import com.chattymin.domain.usecase.FetchAllPokemonUseCase
import com.chattymin.domain.usecase.LoadPokemonDetailsUseCase
import com.chattymin.domain.usecase.LoadPokemonEvolutionUseCase
import com.chattymin.domain.usecase.SearchPokemonFromNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        FetchAllPokemonUseCase(pokemonRepository = get(), configRepository = get())
    }
    factory {
        LoadPokemonDetailsUseCase(pokemonRepository = get())
    }
    factory {
        LoadPokemonEvolutionUseCase(pokemonRepository = get())
    }
    factory {
        SearchPokemonFromNameUseCase(pokemonRepository = get())
    }
}
