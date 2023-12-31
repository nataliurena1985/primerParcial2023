package com.example.magazies.activities.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.magazies.entities.Magazine


@Database(entities = [Magazine::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao



    companion object {
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context)
            }
            return INSTANCE
        }

        private fun buildDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDB"
                    )
                        .addCallback(StartingUsers(context))
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() // No es recomendable que se ejecute en el mainthread
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
