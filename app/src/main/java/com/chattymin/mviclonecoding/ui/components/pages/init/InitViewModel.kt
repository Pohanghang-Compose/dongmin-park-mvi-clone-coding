package com.chattymin.mviclonecoding.ui.components.pages.init

import androidx.lifecycle.ViewModel
import com.chattymin.domain.usecase.FetchAllPokemonUseCase
import com.chattymin.mviclonecoding.ui.common.UiStatus
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class InitViewModel(
    private val fetchAllPokemonUseCase: FetchAllPokemonUseCase,
) : ContainerHost<InitState, InitSideEffect>, ViewModel() {
    override val container = container<InitState, InitSideEffect>(
        InitState(),
    )

    init {
        fetchData()
    }

    fun retry() {
        if (container.stateFlow.value.status != UiStatus.Loading) {
            fetchData()
        }
    }

    private fun fetchData() {
        intent {
            reduce { state.copy(status = UiStatus.Loading) }
            if (fetchAllPokemonUseCase()) {
                reduce { state.copy(status = UiStatus.Success) }
                postSideEffect(InitSideEffect.Completed)
            } else {
                reduce { state.copy(status = UiStatus.Failed()) }
            }
        }
    }
}
