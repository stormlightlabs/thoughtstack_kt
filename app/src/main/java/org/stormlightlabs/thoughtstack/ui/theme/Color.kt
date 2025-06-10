package org.stormlightlabs.thoughtstack.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

data class ColorScheme(
    val rosewater: Color,
    val flamingo: Color,
    val pink: Color,
    val mauve: Color,
    val red: Color,
    val maroon: Color,
    val peach: Color,
    val yellow: Color,
    val green: Color,
    val teal: Color,
    val sky: Color,
    val sapphire: Color,
    val blue: Color,
    val lavender: Color,
    val text: Color,
    val sub1: Color,
    val sub0: Color,
    val overlay2: Color,
    val overlay1: Color,
    val overlay0: Color,
    val surface2: Color,
    val surface1: Color,
    val surface0: Color,
    val base: Color,
    val mantle: Color,
    val crust: Color
)

data class ColorPalette(
    val dark: ColorScheme, val light: ColorScheme
) {
    fun toDarkScheme() = darkColorScheme(
        primary = dark.mauve,
        primaryContainer = dark.red,
        secondary = dark.peach,
        background = dark.base,
        surface = dark.crust,
        onPrimary = dark.crust,
        onSecondary = dark.crust,
        onBackground = dark.text,
        onSurface = dark.text,
    )

    fun toLightScheme() = lightColorScheme(
        primary = light.mauve,
        primaryContainer = light.red,
        secondary = light.peach,
        background = light.base,
        surface = light.crust,
        onPrimary = light.crust,
        onSecondary = light.crust,
        onBackground = light.text,
        onSurface = light.text,
    )
}

/**
 * [Color] palette for the ThoughtStack app using Catppuccin Frappé & Latte for
 * dark and light themes respectively.
 */
object Color {
    val Dark = ColorScheme(
        rosewater = Color(0xFFF2D5CF),
        flamingo = Color(0xFFEEBEBE),
        pink = Color(0xFFF4B8E4),
        mauve = Color(0xFFCA9EE6),
        red = Color(0xFFE78284),
        maroon = Color(0xFFEA999C),
        peach = Color(0xFFEF9F76),
        yellow = Color(0xFFE5C890),
        green = Color(0xFFA6D189),
        teal = Color(0xFF81C8BE),
        sky = Color(0xFF99D1DB),
        sapphire = Color(0xFF85C1DC),
        blue = Color(0xFF8CAAEE),
        lavender = Color(0xFFB7BDF8),
        text = Color(0xFFCAD3F5),
        sub1 = Color(0xFFB8C0E0),
        sub0 = Color(0xFFA5ADCE),
        overlay2 = Color(0xFF939AB7),
        overlay1 = Color(0xFF8087A2),
        overlay0 = Color(0xFF6E738D),
        surface2 = Color(0xFF5B6078),
        surface1 = Color(0xFF494D64),
        surface0 = Color(0xFF363A4F),
        base = Color(0xFF303446),
        mantle = Color(0xFF292C3C),
        crust = Color(0xFF232634)
    )
    val Light = ColorScheme(
        rosewater = Color(0xFFDC8A78),
        flamingo = Color(0xFFDD7878),
        pink = Color(0xFFEA76CB),
        mauve = Color(0xFF8839EF),
        red = Color(0xFFD20F39),
        maroon = Color(0xFFE64553),
        peach = Color(0xFFFE640B),
        yellow = Color(0xFFDF8E1D),
        green = Color(0xFF40A02B),
        teal = Color(0xFF179299),
        sky = Color(0xFF04A5E5),
        sapphire = Color(0xFF209FB5),
        blue = Color(0xFF1E66F5),
        lavender = Color(0xFF7287FD),
        text = Color(0xFF4C4F69),
        sub1 = Color(0xFF5C5F77),
        sub0 = Color(0xFF6C6F85),
        overlay2 = Color(0xFF7C7F93),
        overlay1 = Color(0xFF8C8FA1),
        overlay0 = Color(0xFF9CA0B0),
        surface2 = Color(0xFFACB0BE),
        surface1 = Color(0xFFBCC0CC),
        surface0 = Color(0xFFCCD0DA),
        base = Color(0xFFEFF1F5),
        mantle = Color(0xFFE6E9EF),
        crust = Color(0xFFDCE0E8)
    )

    val Palette = ColorPalette(Dark, Light)
}




