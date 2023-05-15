package com.fighter.honeynotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface NoteDao {

    @Insert
    fun createNote(note: NoteEntity): Completable

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC")
    fun retrieveAllNotes(): Observable<List<NoteEntity>>

    @Update
    fun updateNote(note: NoteEntity): Completable

    @Delete
    fun deleteNote(note: NoteEntity): Completable

}