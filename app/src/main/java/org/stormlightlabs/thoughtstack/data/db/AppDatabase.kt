package org.stormlightlabs.thoughtstack.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.sqlite.db.SupportSQLiteDatabase
import org.stormlightlabs.thoughtstack.data.dao.CardDao
import org.stormlightlabs.thoughtstack.data.dao.DeckDao
import org.stormlightlabs.thoughtstack.data.model.CardEntity
import org.stormlightlabs.thoughtstack.data.model.DeckEntity
import org.stormlightlabs.thoughtstack.util.AssetLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.stormlightlabs.thoughtstack.data.json.DeckJson

@Database(
    entities = [DeckEntity::class, CardEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deckDao(): DeckDao
    abstract fun cardDao(): CardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "thoughtstack.db")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            listOf("cbt_deck.json", "act_deck.json")
                                .map { file ->
                                    Json.decodeFromString<DeckJson>(
                                        AssetLoader.load(context, "decks/$file")
                                    )
                                }.forEach { deckJson ->
                                    val deckEntity = DeckEntity(deckJson.deckId, deckJson.name)
                                    INSTANCE!!.deckDao().insertDeck(deckEntity)
                                    deckJson.cards.forEach { cardJson ->
                                        val cardEntity = CardEntity(
                                            cardJson.cardId,
                                            deckJson.deckId,
                                            cardJson.frontText,
                                            cardJson.backText,
                                            cardJson.imageUri
                                        )
                                        INSTANCE!!.cardDao().insertCard(cardEntity)
                                    }
                                }
                        }
                    }
                })
                .build()
    }
}
