package com.nrc7.mynews.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.views.Utilities;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Article> articles;
    // Adapter Click Listener
    private NewsListener listener;
    private Utilities utils;

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

        String url = articles.get(position).getUrlToImage();
        if (url == null) {
            url = Utilities.DEFAULT_IMAGE_URL;
        }
        initImageItem(url, holder.imageView);

        String[] date = articles.get(position).getPublishedAt().split("T");
        holder.publishedAtTv.setText(date[0]);

        holder.authorTv.setText(articles.get(position).getAuthor());

        holder.titleTv.setText(articles.get(position).getTitle());

        holder.titleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = holder.getAdapterPosition();
                Article article = articles.get(index);
                listener.toDetails(article);
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

    public void initImageItem(String url, ImageView imageView) {
        Picasso.get()
                .load(url)
                .into(imageView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        // author title urlToImage publishedAt
        TextView publishedAtTv;
        TextView titleTv;
        TextView authorTv;
        ImageView imageView;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            publishedAtTv = itemView.findViewById(R.id.publishedAtTv);
            titleTv = itemView.findViewById(R.id.titleTv);
            card = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.imageView);
            authorTv = itemView.findViewById(R.id.authorTv);
        }
    }
}
