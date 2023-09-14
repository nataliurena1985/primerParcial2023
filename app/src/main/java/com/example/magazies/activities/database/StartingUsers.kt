package com.example.magazies.activities.database

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.magazies.R
import com.example.magazies.entities.Magazine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader

class StartingUsers(private val context: Context) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("StartingUsers", "Pre-populating database...")
            fillWithStartingUsers(context)
        }
    }

    /**
     * Pre-populate database with hard-coded users
     */
    private fun fillWithStartingUsers(context: Context) {
        val users = listOf(
            Magazine(0, "caras", 2005, image = "logo", description ="h0y" ),
            Magazine(0, "gente", 2005, image = "logo", description ="h0y"),
            Magazine(0, "caras", 2005, image = "logo", description ="h0y"),
            Magazine(0, "gente", 2005, image = "logo", description ="h0y")
        )
        val dao = AppDatabase.getInstance(context)?.userDao()

        users.forEach {
            dao?.insertMagazine(it)
        }
    }

    /**
     * Pre-populate database with users from a Json file
     */
    private fun fillWithStartingUsersFromJson(context: Context) {
        val dao = AppDatabase.getInstance(context)?.userDao()

        try {
            val users = loadJSONArray(context, R.raw.magazines)
            for (i in 0 until users.length()) {
                val item = users.getJSONObject(i)
                val magazine = Magazine(
                    id = 0,
                    title = item.getString("title"),
                    year= item.getInt("year"),
                    image = item.getString("image"),
                    description = item.getString("description")
                )

                dao?.insertMagazine(magazine)
            }
        } catch (e: JSONException) {
            Log.e("fillWithStartingNotes", e.toString())
        }
    }

    /**
     * Utility to load a JSON array from the raw folder
     */
    private fun loadJSONArray(context: Context, file: Int): JSONArray {
        val inputStream = context.resources.openRawResource(file)

        BufferedReader(inputStream.reader()).use {
            return JSONArray(it.readText())
        }
    }
}
