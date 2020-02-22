package com.nrc7.mynews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.views.Utilities;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Article> articles;
    // Adapter Click Listener
    private NewsListener listener;

    public NewsAdapter(List<Article> articles, NewsListener listener) {
        this.articles = articles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_news, parent, false);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.nameTv.setText(articles.get(position).getPublishedAt());
        holder.authorTv.setText(articles.get(position).getTitle());

        holder.authorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = holder.getAdapterPosition();
                Article article = articles.get(index);
                listener.toDetails(article);
                update();
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    // Update list temporal
    public void update() {
        articles = new Utilities().getAllArticles();
        listener.update(articles);
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
