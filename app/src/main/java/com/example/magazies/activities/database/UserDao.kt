package com.example.magazies.activities.database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.magazies.entities.Magazine


@Dao
interface UserDao {

    @Query("SELECT * FROM magazine ORDER BY id")
    fun fetchAllMagazine(): MutableList<Magazine?>?

    @Query("SELECT * FROM magazine WHERE id = :id")
    fun fetchMagazineById(id: Int): Magazine?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMagazine(magazine: Magazine)

    @Update
    fun updateMagazine(magazine: Magazine)

    @Delete
    fun delete(magazine: Magazine)

    @Query("SELECT COUNT(*) FROM magazine")
    fun count(): Int

    @Query("SELECT * FROM magazine")
    fun getAll(): MutableList<Magazine>






}