package com.fighter.honeynotes.ui.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fighter.honeynotes.data.NoteEntity
import com.fighter.honeynotes.data.NoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : ViewModel() {
    private val repository = NoteRepository()

    private val _notes = MutableLiveData<List<NoteEntity>>()
    val notes: LiveData<List<NoteEntity>>
        get() = _notes

    val noteTitle = MutableLiveData<String>()
    val noteDescription = MutableLiveData<String>()

    init {
        getAllNotes()
    }

    fun createNote() {
        repository.createNote(NoteEntity(0, noteTitle.value, noteDescription.value, "15/5/2023"))
            .subscribeOn(Schedulers.io())
            .subscribe()
        noteTitle.postValue("")
        noteDescription.postValue("")
    }

    @SuppressLint("CheckResult")
    private fun getAllNotes() {
        repository.getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetNotesSuccess , ::onError)
    }

    private fun onGetNotesSuccess(notes:List<NoteEntity>){
        _notes.postValue(notes)
    }
    private fun onError(throwable: Throwable){
        Log.e("getNotesError" , throwable.message.toString())
    }
}