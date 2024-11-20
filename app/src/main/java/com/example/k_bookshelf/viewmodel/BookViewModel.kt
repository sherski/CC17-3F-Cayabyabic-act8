package com.example.k_bookshelf.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.k_bookshelf.BookRepository
import com.example.k_bookshelf.models.Book
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    private val _bookDetails = MutableLiveData<Book>()
    val bookDetails: LiveData<Book> get() = _bookDetails

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            val bookList = repository.getBooks(query)
            _books.postValue(bookList)
            }
    }

    fun fetchBookDetails(id: String) {
        viewModelScope.launch {
            val book = repository.getBook(id)
            book?.let {
                _bookDetails.postValue(it)
            }
        }
    }
}
