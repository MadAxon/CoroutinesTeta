package com.example.testcomposaapplication.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class DesignSystemColors(
    textHeadline: Color,
    textPrimary: Color,
    textSecondary: Color,
    textTertiary: Color,
    textInverted: Color,
    textPositive: Color,
    textNegative: Color,
    textPrimaryLink: Color,
    textSecondaryLink: Color,

    backgroundPrimary: Color,
    backgroundPrimaryElevated: Color,
    backgroundModal: Color,
    backgroundStroke: Color,
    backgroundSecondary: Color,
    backgroundSecondaryElevated: Color,
    backgroundInverted: Color,
    backgroundOverlay: Color,
    backgroundHover: Color,
    backgroundNavbarIos: Color,

    controlsPrimaryActive: Color,
    controlsSecondaryActive: Color,
    controlsTertiaryActive: Color,
    controlsInactive: Color,
    controlsAlternative: Color,
    controlsActiveTabBar: Color,
    controlsInactiveTabBar: Color,

    accentActive: Color,
    accentPositive: Color,
    accentWarning: Color,
    accentNegative: Color,

    brandMtsRed: Color,

    greyScale0: Color,

    isDark: Boolean
) {
    var textHeadline by mutableStateOf(textHeadline)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textTertiary by mutableStateOf(textTertiary)
        private set
    var textInverted by mutableStateOf(textInverted)
        private set
    var textPositive by mutableStateOf(textPositive)
        private set
    var textNegative by mutableStateOf(textNegative)
        private set
    var textPrimaryLink by mutableStateOf(textPrimaryLink)
        private set
    var textSecondaryLink by mutableStateOf(textSecondaryLink)
        private set

    var backgroundPrimary by mutableStateOf(backgroundPrimary)
        private set
    var backgroundPrimaryElevated by mutableStateOf(backgroundPrimaryElevated)
        private set
    var backgroundModal by mutableStateOf(backgroundModal)
        private set
    var backgroundStroke by mutableStateOf(backgroundStroke)
        private set
    var backgroundSecondary by mutableStateOf(backgroundSecondary)
        private set
    var backgroundSecondaryElevated by mutableStateOf(backgroundSecondaryElevated)
        private set
    var backgroundInverted by mutableStateOf(backgroundInverted)
        private set
    var backgroundOverlay by mutableStateOf(backgroundOverlay)
        private set
    var backgroundHover by mutableStateOf(backgroundHover)
        private set
    var backgroundNavbarIos by mutableStateOf(backgroundNavbarIos)
        private set

    var controlsPrimaryActive by mutableStateOf(controlsPrimaryActive)
        private set
    var controlsSecondaryActive by mutableStateOf(controlsSecondaryActive)
        private set
    var controlsTertiaryActive by mutableStateOf(controlsTertiaryActive)
        private set
    var controlsInactive by mutableStateOf(controlsInactive)
        private set
    var controlsAlternative by mutableStateOf(controlsAlternative)
        private set
    var controlsActiveTabBar by mutableStateOf(controlsActiveTabBar)
        private set
    var controlsInactiveTabBar by mutableStateOf(controlsInactiveTabBar)
        private set

    var accentActive by mutableStateOf(accentActive)
        private set
    var accentPositive by mutableStateOf(accentPositive)
        private set
    var accentWarning by mutableStateOf(accentWarning)
        private set
    var accentNegative by mutableStateOf(accentNegative)
        private set

    var brandMtsRed by mutableStateOf(brandMtsRed)
        private set

    var greyScale0 by mutableStateOf(greyScale0)
        private set

    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: DesignSystemColors) {
        textHeadline = other.textHeadline
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textTertiary = other.textTertiary
        textInverted = other.textInverted
        textPositive = other.textPositive
        textNegative = other.textNegative
        textPrimaryLink = other.textPrimaryLink
        textSecondaryLink = other.textSecondaryLink

        backgroundPrimary = other.backgroundPrimary
        backgroundPrimaryElevated = other.backgroundPrimaryElevated
        backgroundModal = other.backgroundModal
        backgroundStroke = other.backgroundStroke
        backgroundSecondary = other.backgroundSecondary
        backgroundSecondaryElevated = other.backgroundSecondaryElevated
        backgroundInverted = other.backgroundInverted
        backgroundOverlay = other.backgroundOverlay
        backgroundHover = other.backgroundHover
        backgroundNavbarIos = other.backgroundNavbarIos

        controlsPrimaryActive = other.controlsPrimaryActive
        controlsSecondaryActive = other.controlsSecondaryActive
        controlsTertiaryActive = other.controlsTertiaryActive
        controlsInactive = other.controlsInactive
        controlsAlternative = other.controlsAlternative
        controlsActiveTabBar = other.controlsActiveTabBar
        controlsInactiveTabBar = other.controlsInactiveTabBar

        accentActive = other.accentActive
        accentPositive = other.accentPositive
        accentWarning = other.accentWarning
        accentNegative = other.accentNegative

        brandMtsRed = other.brandMtsRed

        isDark = other.isDark
    }
}