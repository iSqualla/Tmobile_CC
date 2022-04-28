package com.example.tmobile.ui.controller

import com.example.tmobile.data.Item
import com.example.tmobile.data.SearchResponseItem
import com.example.tmobile.network.RetroAPI
import com.example.tmobile.network.RetroAPIService
import javax.inject.Inject

interface MainRepository {
    suspend fun fetchData(): List<SearchResponseItem>
    suspend fun fetchUser(user: String): SearchResponseItem
    suspend fun searchUser(user: String): List<SearchResponseItem>
}

class MainRepositoryImpl @Inject constructor(retroAPIService: RetroAPIService): MainRepository{
    private val retroAPI : RetroAPI = RetroAPI(retroAPIService)

    override suspend fun fetchData(): List<SearchResponseItem> {
        return retroAPI.fetchData()
    }

    override suspend fun fetchUser(user: String): SearchResponseItem{
        return retroAPI.fetchUser(user)
    }

    override suspend fun searchUser(user: String): List<SearchResponseItem>{
        return retroAPI.searchUser(user)
    }
}
