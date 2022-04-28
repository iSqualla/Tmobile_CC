package com.example.tmobile.network

import com.example.tmobile.data.Item
import com.example.tmobile.data.SearchResponseItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

interface RetroAPIService {
    @GET("users")
    @Headers("Accept: application/vnd.github.v3+json")
    suspend fun fetchData(): List<SearchResponseItem>

    @GET("users/{user}")
    @Headers("Accept: application/vnd.github.v3+json")
    suspend fun fetchUser(
        @Path("user") user: String
    ): SearchResponseItem

    @GET("search/users")
    @Headers("Accept: application/vnd.github.v3+json")
    suspend fun searchUser(
        @Query("q") user: String
    ): List<SearchResponseItem>

}

interface RetroAPIHelper{
    suspend fun fetchData(): List<SearchResponseItem>
    suspend fun fetchUser(user: String): SearchResponseItem
    suspend fun searchUser(user: String): List<SearchResponseItem>
}

class RetroAPI @Inject constructor(private val retroAPIService: RetroAPIService): RetroAPIHelper{
    override suspend fun fetchData(): List<SearchResponseItem> {
        return retroAPIService.fetchData()
    }

    override suspend fun fetchUser(user: String): SearchResponseItem{
        return retroAPIService.fetchUser(user)
    }

    override suspend fun searchUser(user: String): List<SearchResponseItem>{
        return retroAPIService.searchUser(user)
    }
}