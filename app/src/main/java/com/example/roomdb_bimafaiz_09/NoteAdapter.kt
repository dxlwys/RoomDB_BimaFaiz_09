package com.example.roomdb_bimafaiz_09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb_bimafaiz_09.room.Note
import kotlinx.android.synthetic.main.list_note.view.*
import java.text.FieldPosition

class NoteAdapter(private val notes: ArrayList<Note>, private val listener: NoteAdapter.OnAdapterListener)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener {
            listener.onClick( note )
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate( note )
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete( note )
        }

    }

    override fun getItemCount() = notes.size

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    fun setData(list: List<Note>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }
}