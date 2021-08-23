package com.neouto.kotlinnotes.data.model

import androidx.room.Entity

@Entity(tableName = "notes_table")
data class Note(
    val id: Int,
    val title: String,
    val description: String,
    val creationDateAndTime: String,
    val imagePath: String,
    val priority: Int
)