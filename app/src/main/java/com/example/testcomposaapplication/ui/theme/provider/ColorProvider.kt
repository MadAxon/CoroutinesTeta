package com.example.testcomposaapplication.ui.theme.provider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.testcomposaapplication.ui.theme.DesignSystemColors

val LocalDesignSystemColors = staticCompositionLocalOf<DesignSystemColors> {
    error("No palette provided")
}

@Composable
fun ProvideDesignSystemColors(
    colors: DesignSystemColors,
    content: @Composable () -> Unit,
) {
    val palette = remember { colors }
    palette.update(colors)
    CompositionLocalProvider(
        values = arrayOf(LocalDesignSystemColors provides palette),
        content = content
    )
}