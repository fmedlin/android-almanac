package org.fmedlin.almanac_core.presentation.util

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass

@Composable
fun currentDeviceConfiguration(
    supportLargeAndXLargeWidth: Boolean = true
): DeviceConfiguration {
    val windowSizeClass = currentWindowAdaptiveInfo(supportLargeAndXLargeWidth).windowSizeClass
    return DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
}

enum class DeviceConfiguration {
    Compact,
    Medium,
    Expanded,
    Large,
    ExtraLarge;

    companion object {
        fun fromWindowSizeClass(sizeClass: WindowSizeClass): DeviceConfiguration {
            return with(sizeClass) {
                when {
                    isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXTRA_LARGE_LOWER_BOUND) ->
                        ExtraLarge
                    isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND) ->
                        Large
                    isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND) ->
                        Expanded
                    isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) ->
                        Medium
                    else ->
                        Compact
                }
            }
        }
    }
}