package com.example.k_bookshelf.models

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>?,
    val descriptor: String?,
    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val thumbnail: String
)
