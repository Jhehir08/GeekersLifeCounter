package com.example.geekerslifecounter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geekerslifecounter.CounterViewModel.Companion.Variant.TWO_PLAYER_COMMANDER
import com.example.geekerslifecounter.CounterViewModel.Companion.Variant.THREE_PLAYER_COMMANDER
import com.example.geekerslifecounter.CounterViewModel.Companion.Variant.FOUR_PLAYER_COMMANDER
import kotlinx.coroutines.launch

class CounterViewModel(
    mode: Variant
) : ViewModel() {
    companion object {
        enum class Variant {
            TWO_PLAYER_COMMANDER,
            THREE_PLAYER_COMMANDER,
            FOUR_PLAYER_COMMANDER
        }
        val twoPlayerCommander = mutableListOf(40, 40)
        val threePlayerCommander = mutableListOf(40, 40, 40)
        val fourPlayerCommander = mutableListOf(40, 40, 40, 40)
    }

    var playerLifeCounters: MutableState<MutableList<Int>> = mutableStateOf(mutableListOf())

    init {
        playerLifeCounters = when (mode) {
            TWO_PLAYER_COMMANDER -> mutableStateOf(twoPlayerCommander)
            THREE_PLAYER_COMMANDER -> mutableStateOf(threePlayerCommander)
            FOUR_PLAYER_COMMANDER -> mutableStateOf(fourPlayerCommander)
        }
    }

    fun addLife(player: Int, totalAdded: Int = 1) {
        viewModelScope.launch {
            playerLifeCounters.value[player] = playerLifeCounters.value[player].plus(totalAdded)
        }
    }

    fun subtractLife(player: Int, totalSubtracted: Int = 1) {
        viewModelScope.launch {
            playerLifeCounters.value[player] = playerLifeCounters.value[player].minus(totalSubtracted)
        }
    }
}
