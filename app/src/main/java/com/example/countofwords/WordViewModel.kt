package com.example.countofwords

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordViewModel: ViewModel() {

    var wordList = MutableLiveData<MutableList<WordItem>>()

    init{

    }

    fun onClickedSaveButton(wordItem: String){

        if(wordList.value==null){
            var list: MutableList<WordItem> = ArrayList()
            list.add(WordItem(wordItem, 1))
            wordList.value = list
        }else{
            var list: MutableList<WordItem> = wordList.value!!
            var listTitle = mutableListOf<String>()
            for(i in 0..list.size-1){
                listTitle.add(list.get(i).title)
            }
            if(!listTitle.contains(wordItem)){
                list.add(WordItem(wordItem, 1))

            }
            else{
                var temp = listTitle.indexOf(wordItem)
                var temp1 = list[temp].count.inc()
                list[temp].count = temp1
            }
            wordList.value = list

        }

    }

}