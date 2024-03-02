package com.chattymin.mviclonecoding.ui.components.pages.details

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class DetailsViewModel(
    private val id: Int,
    private val loadPokemonDetailsUseCase: LoadPokemonDetailsUseCase,
    private val loadPokemonEvolutionUseCase: LoadPokemonEvolutionUseCase
) : ContainerHost<DetailsState, DetailsSideEffect>, ViewModel() {
    override val container = container<DetailsState, DetailsSideEffect>(
        DetailsState()
    )

    init {
        intent {
            val details = loadPokemonDetailsUseCase(id)
            val evolutions = loadPokemonEvolutionUseCase(id)
            if (details != null) {
                reduce {
                    state.copy(
                        status = UiStatus.Success,
                        details = details,
                        evolutions = evolutions
                    )
                }
            } else {
                reduce {
                    state.copy(
                        status = UiStatus.Failed("Loading Error."),
                        details = null,
                        evolutions = emptyList()
                    )
                }
            }
        }
    }
}
