package com.nrc7.mynews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    // Replace with List of News Models
    private List<Article> articles;
    // HandCraft Click Listener
    private NewsListener listener;

    public NewsAdapter(List<Article> articles, NewsListener listener) {
        this.articles = articles;
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
        holder.nameTv.setText(articles.get(position).getPublishedAt());
        holder.authorTv.setText(articles.get(position).getTitle());

        holder.authorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int z = holder.getAdapterPosition();
                listener.clicked(z);
                Article article = articles.get(z);
                listener.transporting(article);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    // HandCraft CRUD Functionality
    public void addArticle(Article article) {
        this.articles.add(article);
        notifyDataSetChanged();
    }

    public void deleteArticle() {
        if (articles.size() > 0) {
            articles.remove(getItemCount() - 1);
            notifyDataSetChanged();
        }
    }

    public void cleanArticles() {
        articles.clear();
        notifyDataSetChanged();
    }

    public void resetArticles() {
        articles.clear();
        // articles = new Book().getAllBooks();
        notifyDataSetChanged();
    }

    public void update(int i) {

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
