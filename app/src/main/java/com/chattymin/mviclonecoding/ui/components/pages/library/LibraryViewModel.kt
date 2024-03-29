package com.chattymin.mviclonecoding.ui.components.pages.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chattymin.domain.usecase.SearchPokemonFromNameUseCase
import com.chattymin.mviclonecoding.ui.common.UiStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class LibraryViewModel(
    private val searchPokemonUseCase: SearchPokemonFromNameUseCase,
) : ContainerHost<LibraryState, LibrarySideEffect>, ViewModel() {
    private var searchJob: Job? = null

    override val container = container<LibraryState, LibrarySideEffect>(
        LibraryState(),
    )

    init {
        intent {
            searchPokemon(state.searchText)
        }
    }

    fun searchPokemon(searchText: String) {
        intent {
            searchJob?.cancel()
            searchJob = viewModelScope.launch(Dispatchers.IO) {
                reduce {
                    state.copy(
                        status = UiStatus.Loading,
                        searchText = searchText,
                        detailsList = emptyList(),
                    )
                }

                val details = searchPokemonUseCase(state.searchText)
                delay(1000)

                if (details.isNotEmpty()) {
                    reduce {
                        state.copy(
                            status = UiStatus.Success,
                            detailsList = details,
                        )
                    }
                } else {
                    reduce {
                        state.copy(
                            status = UiStatus.Failed("Not Found"),
                            detailsList = details,
                        )
                    }
                }
            }
        }
    }

    fun showDetails(id: Int) {
        intent {
            postSideEffect(LibrarySideEffect.ShowDetails(id))
        }
    }
}
