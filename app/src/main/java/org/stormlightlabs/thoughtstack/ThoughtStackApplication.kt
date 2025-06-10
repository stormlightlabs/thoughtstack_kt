package org.stormlightlabs.thoughtstack

import android.app.Application
import androidx.core.content.edit
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.stormlightlabs.thoughtstack.data.AppDatabase
import org.stormlightlabs.thoughtstack.data.AssetLoader
import org.stormlightlabs.thoughtstack.data.Constants
import javax.inject.Inject

/**
 * The Application subclass initializes Hilt and triggers asset → database loading on first launch.
 */
@HiltAndroidApp
class ThoughtStackApplication : Application() {
    @Inject
    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        val prefs = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE)
        if (prefs.getBoolean(Constants.PREF_FIRST_RUN, true)) {
            CoroutineScope(Dispatchers.IO).launch {
                AssetLoader.loadFromAssets(this@ThoughtStackApplication, db)
                prefs.edit { putBoolean(Constants.PREF_FIRST_RUN, false) }
            }
        }
    }
}