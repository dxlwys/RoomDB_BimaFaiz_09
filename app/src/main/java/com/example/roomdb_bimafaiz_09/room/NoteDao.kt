package com.example.roomdb_bimafaiz_09.room

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(Note: Note)

    @Update
    suspend fun updateNote(Note: Note)

    @Delete
    suspend fun deleteNote(Note: Note)

    @Query ("SELECT * FROM note")
    suspend fun getNotes():List<Note>

    @Query ("SELECT * FROM note WHERE id=:note_id")
    suspend fun getNotes(note_id: Int): List<Note>
}