package com.kiko.yandexmusicapi.data.common

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.skydoves.sealedx.core.Extensive
import com.skydoves.sealedx.core.annotations.ExtensiveModel
import com.skydoves.sealedx.core.annotations.ExtensiveSealed

@ExtensiveSealed(
    models = [
        ExtensiveModel(StatusEntity::class)
    ]
)
/**
 * Состояния возвращения результата
 */
sealed interface YandexState {
    data class Success(val data: Extensive) : YandexState
    data class Error(val message: String) : YandexState
}