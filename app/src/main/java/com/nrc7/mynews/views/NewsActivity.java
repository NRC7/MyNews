package com.nrc7.mynews.views;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.nrc7.mynews.R;
import com.nrc7.mynews.adapters.NewsAdapter;
import com.nrc7.mynews.adapters.NewsListener;
import com.nrc7.mynews.models.Article;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements NewsListener {

    private NewsAdapter newsAdapter;
    private RecyclerView newsRV;
    private TextView emptyListTV;
    private List<Article> mArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        emptyListTV = findViewById(R.id.emptyListTv);
        newsRV = findViewById(R.id.NewsRv);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        newsRV.setLayoutManager(manager);
        newsRV.setHasFixedSize(true);

        mArticles = (List<Article>) getIntent().getSerializableExtra(Utilities.SPLASH_LIST_KEY);

        newsAdapter = new NewsAdapter(mArticles, this);
        newsRV.setAdapter(newsAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smoothScrollToLast();
            }
        });
    }

    // HandCraft Smooth Scrolling Animation
    private void smoothScrollToLast() {
        int newsAdapterItemCount = newsAdapter.getItemCount();
        if (newsAdapterItemCount > 0) {
            newsRV.smoothScrollToPosition(newsAdapterItemCount - 1);
        } else {
            emptyListTV.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void toDetails(Article article) {
        Intent intent = new Intent(this, NewsDetailsActivity.class);
        intent.putExtra(Utilities.DETAILS_KEY, article);
        startActivity(intent);
    }

    @Override
    public void update(List<Article> articles) {
        mArticles = articles;
    }

    @Override
    public void onBackPressed() {
        // Temporal solution to prevent user from going back to SplashActivity
    }
}
