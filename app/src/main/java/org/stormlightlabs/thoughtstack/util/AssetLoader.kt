package org.stormlightlabs.thoughtstack.util

import android.content.Context

object AssetLoader {
    fun load(context: Context, assetPath: String): String =
        context.assets.open(assetPath)
            .bufferedReader()
            .use { it.readText() }
}