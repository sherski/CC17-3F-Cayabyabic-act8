package com.example.k_bookshelf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.k_bookshelf.models.Book

class BookAdapter(private val books: List<Book>,
                  private val listener: OnItemClickListener) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

        interface OnItemClickListener {
            fun onItemClick(book: Book)
        }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookImage: ImageView = view.findViewById(R.id.bookImage)
        val bookTitle: TextView = view.findViewById(R.id.bookTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bookTitle.text = book.volumeInfo.title
        book.volumeInfo.imageLinks?.thumbnail?.let {
            holder.bookImage.load(it.replace("http", "https"))
        }
        holder.itemView.setOnClickListener {
            listener.onItemClick(book)
        }
    }

    override fun getItemCount() = books.size
}
