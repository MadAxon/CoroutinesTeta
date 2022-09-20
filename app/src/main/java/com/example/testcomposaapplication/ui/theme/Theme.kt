package com.example.testcomposaapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.testcomposaapplication.ui.theme.palette.*
import com.example.testcomposaapplication.ui.theme.provider.LocalDesignSystemColors
import com.example.testcomposaapplication.ui.theme.provider.LocalDesignSystemTypography
import com.example.testcomposaapplication.ui.theme.provider.ProvideDesignSystemColors
import com.example.testcomposaapplication.ui.theme.provider.ProvideDesignSystemTypography
import ru.mts.design.debugColors

val lightPalette = DesignSystemColors(
    /** Text **/
    textHeadline = TextHeadline,
    textPrimary = TextPrimary,
    textSecondary = TextSecondary,
    textTertiary = TextTertiary,
    textInverted = TextInverted,
    textPositive = TextPositive,
    textNegative = TextNegative,
    textPrimaryLink = TextPrimaryLink,
    textSecondaryLink = TextSecondaryLink,

    /** Background **/
    backgroundPrimary = BackgroundPrimary,
    backgroundPrimaryElevated = BackgroundPrimaryElevated,
    backgroundModal = BackgroundModal,
    backgroundStroke = BackgroundStroke,
    backgroundSecondary = BackgroundSecondary,
    backgroundSecondaryElevated = BackgroundSecondaryElevated,
    backgroundInverted = BackgroundInverted,
    backgroundOverlay = BackgroundOverlay,
    backgroundHover = BackgroundHover,
    backgroundNavbarIos = BackgroundNavbarIos,

    /** Controls **/
    controlsPrimaryActive = ControlPrimaryActive,
    controlsSecondaryActive = ControlSecondaryActive,
    controlsTertiaryActive = ControlTertiaryActive,
    controlsInactive = ControlInactive,
    controlsAlternative = ControlAlternative,
    controlsActiveTabBar = ControlActiveTabbar,
    controlsInactiveTabBar = ControlInactiveTabbar,

    /** Accent **/
    accentActive = AccentActive,
    accentPositive = AccentPositive,
    accentWarning = AccentWarning,
    accentNegative = AccentNegative,

    brandMtsRed = Brand,
    greyScale0 = GreyScale0,

    isDark = false
)

val darkPalette = DesignSystemColors(
    /** Text **/
    textHeadline = TextHeadlineDark,
    textPrimary = TextPrimaryDark,
    textSecondary = TextSecondaryDark,
    textTertiary = TextTertiaryDark,
    textInverted = TextInvertedDark,
    textPositive = TextPositiveDark,
    textNegative = TextNegativeDark,
    textPrimaryLink = TextPrimaryLinkDark,
    textSecondaryLink = TextSecondaryLinkDark,

    /** Background **/
    backgroundPrimary = BackgroundPrimaryDark,
    backgroundPrimaryElevated = BackgroundPrimaryElevatedDark,
    backgroundModal = BackgroundModalDark,
    backgroundStroke = BackgroundStrokeDark,
    backgroundSecondary = BackgroundSecondaryDark,
    backgroundSecondaryElevated = BackgroundSecondaryElevatedDark,
    backgroundInverted = BackgroundInvertedDark,
    backgroundOverlay = BackgroundOverlayDark,
    backgroundHover = BackgroundHoverDark,
    backgroundNavbarIos = BackgroundNavbarIosDark,

    /** Controls **/
    controlsPrimaryActive = ControlPrimaryActiveDark,
    controlsSecondaryActive = ControlSecondaryActiveDark,
    controlsTertiaryActive = ControlTertiaryActiveDark,
    controlsInactive = ControlInactiveDark,
    controlsAlternative = ControlAlternativeDark,
    controlsActiveTabBar = ControlActiveTabbarDark,
    controlsInactiveTabBar = ControlInactiveTabbarDark,

    /** Accent **/
    accentActive = AccentActiveDark,
    accentPositive = AccentPositiveDark,
    accentWarning = AccentWarningDark,
    accentNegative = AccentNegativeDark,

    brandMtsRed = Brand,
    greyScale0 = GreyScale0,

    isDark = true
)

@Composable
fun DesignSystemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) darkPalette else lightPalette
    val typography = DesignSystemTypography()

    ProvideDesignSystemTypography(typography) {
        ProvideDesignSystemColors(colors) {
            MaterialTheme(
                colors = debugColors(darkTheme), // hardcode colors
                typography = debugTypography(), // hardcode typography
                content = content
            )
        }
    }
}

object DesignSystemTheme {
    val colors: DesignSystemColors
        @Composable
        get() = LocalDesignSystemColors.current

    val typography: DesignSystemTypography
        @Composable
        get() = LocalDesignSystemTypography.current
}