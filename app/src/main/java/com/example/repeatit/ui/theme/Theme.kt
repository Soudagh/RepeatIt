package com.example.repeatit.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Blue20,
    primaryContainer = Blue30,
    onPrimaryContainer = Blue90,
    secondary = Indigo80,
    onSecondary = Indigo20,
    secondaryContainer = Indigo30,
    onSecondaryContainer = Indigo90,
    tertiary = Turquoise80,
    onTertiary = Turquoise20,
    tertiaryContainer = Turquoise30,
    onTertiaryContainer = Turquoise90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,

    background = Blue10,
    surface = Blue10,
    onSurface = LightBlue10,
    onBackground = LightBlue10,

)

private val LightColorScheme = lightColorScheme(
    surface = Color.White,
    onSurface = Blue10,
    background = Color.White,
    onBackground = Blue10,
    primary = Blue,
    onPrimary = Color.White,
    primaryContainer = LightBlue,
    onPrimaryContainer = DarkBlue,
    secondary = Indigo,
    secondaryContainer = LightIndigo,
    onSecondaryContainer = DarkIndigo,
    tertiary = Turquoise,
    tertiaryContainer = LightTurquoise,
    onTertiaryContainer = DarkTurquoise,
    error = Red,
    errorContainer = LightRed,
    onErrorContainer = DarkRed,
    onSecondary = Color.White
)

@Composable
fun RepeatItTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        // Dynamic color is available on Android 12+
        dynamicColor: Boolean = false,
        content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            if (darkTheme) {
                window.statusBarColor = colorScheme.onPrimary.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars
            } else {
                window.statusBarColor = colorScheme.primary.toArgb()
            }
        }
    }

    MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
    )
}