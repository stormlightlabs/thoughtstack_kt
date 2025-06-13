package org.stormlightlabs.thoughtstack

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.stormlightlabs.thoughtstack.data.db.AppDatabase
import org.stormlightlabs.thoughtstack.data.db.CardDao
import org.stormlightlabs.thoughtstack.data.db.DeckDao
import org.stormlightlabs.thoughtstack.data.db.DeckRepository
import javax.inject.Singleton

/**
 * Hilt module that provides singletons for the [Room] database, DAOs, and the [DeckRepository].
 */
@Module
@InstallIn(SingletonComponent::class)
object ThoughtStackAppModule {
    const val DATABASE_NAME = "thought_stack.db"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(
            ctx, AppDatabase::class.java, DATABASE_NAME
        ).build()

    @Provides
    fun provideDeckDao(db: AppDatabase): DeckDao = db.deckDao()

    @Provides
    fun provideCardDao(db: AppDatabase): CardDao = db.cardDao()

    @Provides
    @Singleton
    fun provideDeckRepository(deckDao: DeckDao, cardDao: CardDao) =
        DeckRepository(deckDao, cardDao)
}
