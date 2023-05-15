package com.fighter.honeynotes.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.fighter.honeynotes.data.NoteEntity

class NoteDiffUtil(
    private val oldList: List<NoteEntity>,
    private val newList: List<NoteEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition] == newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}