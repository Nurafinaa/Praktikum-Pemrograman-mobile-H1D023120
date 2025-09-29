package com.example.ifunsoedmobile.data.network
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.ifunsoedmobile.data.model.SearchResponse
import retrofit2.Response

interface OpenLibraryApi {
    @GET ( value = "search.json")
    suspend fun searchBooks(
        @Query(value = "q") query: String,
        @Query(value = "limit") limit: Int
    ): Response<SearchResponse>
}