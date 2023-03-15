package com.example.countofwords

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etText: EditText
    private lateinit var btnSave: Button
    private lateinit var rvList: RecyclerView
    private var listOfWord = mutableListOf<WordItem>()
    private lateinit var myViewModel: WordViewModel

    private fun init() {
        etText = findViewById(R.id.etText)
        btnSave = findViewById(R.id.btnSave)
        rvList = findViewById(R.id.rvList)
        rvList.setBackgroundColor(getResources().getColor(R.color.gray))

        rvList.layoutManager = LinearLayoutManager(this)


        myViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


        btnSave.setOnClickListener {
            myViewModel.onClickedSaveButton(etText.text.toString())
            rvList.adapter = RecyclerListAdapter(listOfWord)}
    }

    override fun onStart() {
        super.onStart()
        myViewModel.wordList.observe(this, Observer {
            listOfWord = myViewModel.wordList.value!!
        })
    }
}