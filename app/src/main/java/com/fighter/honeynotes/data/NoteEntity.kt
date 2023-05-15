package com.fighter.honeynotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTE_TABLE")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val date: String,
)