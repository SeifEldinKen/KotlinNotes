package com.neouto.kotlinnotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.neouto.kotlinnotes.R
import com.neouto.kotlinnotes.data.db.NoteDatabase
import com.neouto.kotlinnotes.data.repository.NoteRepository
import com.neouto.kotlinnotes.databinding.ActivityMainBinding
import com.neouto.kotlinnotes.viewmodel.NoteViewModel
import com.neouto.kotlinnotes.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    // --> Init view binding
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // --> Init repository
    private val repository: NoteRepository by lazy {
        NoteRepository(NoteDatabase.getInstance(this).noteDao())
    }

    // --> Init viewModel
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModelFactory(repository))
            .get(NoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}