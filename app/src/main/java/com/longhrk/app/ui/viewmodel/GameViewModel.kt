package com.longhrk.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.longhrk.app.ui.viewmodel.model.Challenge
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {
    private var _currentChallenge = MutableStateFlow<Challenge?>(null)
    val currentChallenge = _currentChallenge

    fun setCurrentChallenge(challenge: Challenge) {
        _currentChallenge.value = challenge
    }
}