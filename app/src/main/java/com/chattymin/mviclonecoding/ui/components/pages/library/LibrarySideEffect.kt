package com.chattymin.mviclonecoding.ui.components.pages.library

sealed class LibrarySideEffect {
    data class ShowDetails(val id: Int) : LibrarySideEffect()
}
