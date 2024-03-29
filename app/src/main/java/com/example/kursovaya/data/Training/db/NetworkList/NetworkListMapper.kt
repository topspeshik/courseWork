package com.example.kursovaya.data.Training.db.NetworkList

import com.example.kursovaya.data.Training.db.models.NetworkItemDbModel
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem
import javax.inject.Inject

class NetworkListMapper @Inject constructor(){
    fun mapNetworkDbToEntity(networkItemDbModel: NetworkItemDbModel) = NetworkItem(
        exercise_name = networkItemDbModel.exercise_name,
        urlimg = networkItemDbModel.urlimg,
        urlgif = networkItemDbModel.urlgif
    )

    fun mapEntityToNetoworkDb(networkItem: NetworkItem) = NetworkItemDbModel(
        exercise_name = networkItem.exercise_name,
        urlgif = networkItem.urlgif,
        urlimg = networkItem.urlimg
    )

    fun mapListNetworkDbToListEntity(list: List<NetworkItemDbModel>) = list.map{
        mapNetworkDbToEntity(it)
    }
}