package com.kishor.kotlin.room_database.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kishor.kotlin.room_database.data.Word
import com.kishor.kotlin.room_database.data.WordRepository
import com.kishor.kotlin.room_database.data.WordRoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val liveData: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDB.getDataBase(application).wordDao()
        repository = WordRepository(wordDao)
        liveData = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertWord(word)
    }
}
