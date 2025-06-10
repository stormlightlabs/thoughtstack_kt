package org.stormlightlabs.thoughtstack.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Module providing Room db and DAO deps
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseMod {
    const val DATABASE_NAME = "thoughtstack_app_db"

    /**
     * Provides a singleton instance of [AppDatabase] for the entire app.
     * Uses Room's databaseBuilder to create or open the database named [DATABASE_NAME].
     *
     * @param context Application context for DB initialization.
     * @return Configured [AppDatabase] instance.
     */
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

    /**
     * Provides a [DeckDao] implementation from [AppDatabase].
     *
     * @param db The Room database instance.
     * @return DAO for deck operations.
     */
    @Provides
    fun provideDeckDao(db: AppDatabase) = db.deckDao()
}