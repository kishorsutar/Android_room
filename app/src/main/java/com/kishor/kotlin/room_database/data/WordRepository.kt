package com.kishor.kotlin.room_database.data

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAlphaBetizedWords()

    suspend fun insertWord(word: Word) {
        wordDao.insert(word)
    }
}