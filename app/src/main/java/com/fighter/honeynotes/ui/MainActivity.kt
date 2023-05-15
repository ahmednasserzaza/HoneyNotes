package com.fighter.honeynotes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fighter.honeynotes.R
import com.fighter.honeynotes.data.NoteDatabase
import com.fighter.honeynotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        NoteDatabase.getInstance(applicationContext) // This is work around instance before study dependency injection
    }
}