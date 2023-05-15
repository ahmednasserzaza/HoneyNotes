package com.fighter.honeynotes.data

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class NoteRepository {
    private val dao = NoteDatabase.getRandomInstance().noteDao()

    fun createNote(note: NoteEntity): Completable {
        return dao.createNote(note)
    }

    fun getAllNotes(): Observable<List<NoteEntity>> = dao.retrieveAllNotes()
}