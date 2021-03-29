package me.ibrahimsn.lib

import me.ibrahimsn.lib.internal.lifecycle.Lifecycle
import me.ibrahimsn.lib.internal.webSocket.WebSocket

sealed class Event {

    sealed class OnLifecycle : Event() {
        data class StateChange<out T : Lifecycle.State> internal constructor(val state: T) : OnLifecycle()

        object Terminate : OnLifecycle()
    }

    sealed class OnWebSocket : Event() {
        data class Event<out T : WebSocket.Event> internal constructor(val event: T) : OnWebSocket()

        object Terminate : OnWebSocket()
    }

    data class OnStateChange<out T : State> internal constructor(val state: T) : Event()

    object OnRetry : Event()
}
