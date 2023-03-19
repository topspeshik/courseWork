package com.example.kursovaya.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface NetworkListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNetworkItem(NetworkItemDbModel: NetworkItemDbModel)
}