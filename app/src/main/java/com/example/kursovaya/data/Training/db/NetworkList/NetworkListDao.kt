package com.example.kursovaya.data.Training.db.NetworkList

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursovaya.data.Training.db.models.NetworkItemDbModel

@Dao
interface NetworkListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNetworkItem(NetworkItemDbModel: NetworkItemDbModel)

    @Query("SELECT * FROM network_items WHERE exercise_name LIKE :sym")
    fun searchName(sym: String): LiveData<List<NetworkItemDbModel>>
}