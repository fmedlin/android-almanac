package org.fmedlin.almanac_core.presentation.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed interface UiText {
    data class DynamicString(val value: String): UiText
    class Resource(
        @field:StringRes val resId: Int,
        val args: Array<Any> = arrayOf()
    ): UiText

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is Resource -> stringResource(
                resId,
                *args
            )
        }
    }

    suspend fun asStringAsync(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is Resource -> context.getString(
                resId,
                *args
            )
        }
    }
}