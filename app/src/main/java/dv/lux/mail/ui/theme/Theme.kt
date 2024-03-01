package dv.lux.mail.ui.theme

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = AppColor.SoftBlue,
    secondary = AppColor.LightViolet,
    tertiary = AppColor.DarkSalmon,

    background = AppColor.Eclipse,
    surface = AppColor.Eclipse,
    onPrimary = AppColor.White,
    onSecondary = AppColor.White,
    onTertiary = AppColor.White,
    onBackground = AppColor.SilverChalice,
    onSurface = AppColor.SilverChalice,
)

private val lightColorScheme = lightColorScheme(
    primary = AppColor.SoftBlue,
    secondary = AppColor.LightViolet,
    tertiary = AppColor.DarkSalmon,

    background = AppColor.GhostWhite,
    surface = AppColor.GhostWhite,
    onPrimary = AppColor.White,
    onSecondary = AppColor.White,
    onTertiary = AppColor.White,
    onBackground = AppColor.SilverChalice,
    onSurface = AppColor.SilverChalice,
)

@Composable
fun MailTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}