package com.foodics.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : Any>(initialState: State) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    protected fun <T> execute(
        loadingSetter: ((Boolean) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        block: suspend () -> T,
        onSuccess: (T) -> Unit
    ) {
        viewModelScope.launch {
            loadingSetter?.invoke(true)
            try {
                val result = block()
                onSuccess(result)
            } catch (e: Throwable) {
                onError?.invoke(e)
            } finally {
                loadingSetter?.invoke(false)
            }
        }
    }
}

