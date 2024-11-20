package com.example.k_bookshelf.api

import com.example.k_bookshelf.models.BookResponse
import com.example.k_bookshelf.models.Book
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("startIndex") startIndex: Int = 0,
        @Query("maxResults") maxResult: Int = 20): BookResponse

    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id:String):Book
}

