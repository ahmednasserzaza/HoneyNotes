package com.fighter.honeynotes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fighter.honeynotes.R
import com.fighter.honeynotes.data.NoteDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NoteDatabase.getInstance(this) // This is work around instance before study dependency injection
    }
}