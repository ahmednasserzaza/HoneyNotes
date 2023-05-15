package com.fighter.honeynotes.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fighter.honeynotes.data.NoteEntity
import com.fighter.honeynotes.ui.home.NotesAdapter

@BindingAdapter(value = ["app:items"])
fun setRecyclerItems(recyclerView: RecyclerView, items: List<NoteEntity>) {
    if (items.isNotEmpty()) {
        (recyclerView.adapter as NotesAdapter).setItems(items)
    }
    else{
        (recyclerView.adapter as NotesAdapter).setItems(emptyList())
    }
}