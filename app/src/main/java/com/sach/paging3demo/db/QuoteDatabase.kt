package com.sach.paging3demo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sach.paging3demo.models.QuoteRemoteKeys
import com.sach.paging3demo.models.Result

@Database(entities = [Result::class, QuoteRemoteKeys::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao
    abstract fun remoteKeysDao() : RemoteKeysDao
}