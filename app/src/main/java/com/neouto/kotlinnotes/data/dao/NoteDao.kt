package com.neouto.kotlinnotes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.neouto.kotlinnotes.data.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun fetchAllNotes(): LiveData<Note>

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM notes_table")
    fun deleteAllNotes()

}