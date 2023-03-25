package com.example.kursovaya.data.db.NetworkList

import com.example.kursovaya.data.db.models.NetworkItemDbModel
import com.example.kursovaya.domain.db.Network.NetworkItem

class NetworkListMapper {
    private fun mapNetworkDbToEntity(networkItemDbModel: NetworkItemDbModel) = NetworkItem(
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