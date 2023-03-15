package com.example.countofwords

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etText: EditText
    private lateinit var btnSave: Button
    private lateinit var rvList: RecyclerView
    private var listOfWord = mutableListOf<WordItem>()

    private fun init() {
        etText = findViewById(R.id.etText)
        btnSave = findViewById(R.id.btnSave)
        rvList = findViewById(R.id.rvList)
        rvList.setBackgroundColor(getResources().getColor(R.color.gray))

        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = RecyclerListAdapter(listOfWord)

        listOfWord.add(WordItem("Hello", 0))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
}