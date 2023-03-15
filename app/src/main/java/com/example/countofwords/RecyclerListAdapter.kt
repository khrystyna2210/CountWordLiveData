package com.example.countofwords

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerListAdapter(
    private var wordList: List<WordItem>
): RecyclerView.Adapter<ListViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.card_item, parent, false)
        return ListViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var item = wordList.get(position)
        holder.bind(item)
    }
}

class ListViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(word: WordItem){
        var wordText = view.findViewById<TextView>(R.id.tvWord)
        var count = view.findViewById<TextView>(R.id.tvCount)
        wordText.text = word.title
        count.text = word.count.toString()
    }
}