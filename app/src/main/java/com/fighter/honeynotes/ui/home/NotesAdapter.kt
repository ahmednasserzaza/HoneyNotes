package com.fighter.honeynotes.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fighter.honeynotes.BR
import com.fighter.honeynotes.data.NoteEntity
import com.fighter.honeynotes.databinding.ItemNoteBinding

class NotesAdapter(private val notes: List<NoteEntity>) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: ItemNoteBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(ItemNoteBinding.inflate(inflater))
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = notes[position]
        with(holder.binding){
            setVariable(BR.item , currentItem)
        }
    }

}