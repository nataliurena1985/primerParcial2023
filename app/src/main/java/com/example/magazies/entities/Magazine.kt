package com.example.magazies.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Magazine")

class Magazine (
    id : Int,
    title : String,
    year : Int,
    image : String,
    description : String,
      )
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int
    @ColumnInfo(name = "title")
    var title : String
    @ColumnInfo(name = "year")
    var year : Int

    @ColumnInfo(name = "image")
    var image : String


    @ColumnInfo(name = "description")
    var description : String

    init {
        this.id= id
        this.title = title
        this.year= year

        this.image= image

        this.description= description

    }



}