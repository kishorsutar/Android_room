package com.kishor.kotlin.room_database.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kishor.kotlin.room_database.R
import com.kishor.kotlin.room_database.data.Word

class WordAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItem : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun getItemCount() = words.size

    override fun onBindViewHolder(holderWord: WordViewHolder, position: Int) {
        val current = words[position]
        holderWord.wordItem.text = current.word
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }
}
