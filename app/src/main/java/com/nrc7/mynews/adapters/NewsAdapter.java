package com.nrc7.mynews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Book;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    // Replace with List of News Models
    private List<Book> books;
    // HandCraft Click Listener
    private NewsListener listener;

    public NewsAdapter(List<Book> books, NewsListener listener) {
        this.books = books;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (parent != null) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_news, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.nameTv.setText(books.get(position).getName());
        holder.authorTv.setText(books.get(position).getAuthor());

        holder.authorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int z = holder.getAdapterPosition();
                listener.clicked(z);
                // Book selectedBook = books.get(z);
                // listener.transporting(selectedBook);
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    // HandCraft CRUD Functionality
    public void addBook(Book book) {
        books.add(book);
        notifyDataSetChanged();
    }

    public void deleteBook() {
        if (books.size() > 0) {
            books.remove(getItemCount() - 1);
            notifyDataSetChanged();
        }
    }

    public void clean() {
        books.clear();
        notifyDataSetChanged();
    }

    public void reset() {
        books.clear();
        books = new Book().getAllBooks();
        notifyDataSetChanged();
    }

    public void update(int i) {
        books.get(i).setName("piratas del caribe");
        books.get(i).setAuthor("anonimo");
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        TextView authorTv;
        LinearLayout card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            authorTv = itemView.findViewById(R.id.authorTv);
            card = itemView.findViewById(R.id.card);
        }
    }
}
