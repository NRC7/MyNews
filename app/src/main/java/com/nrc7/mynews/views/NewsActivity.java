package com.nrc7.mynews.views;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nrc7.mynews.R;
import com.nrc7.mynews.adapters.NewsAdapter;
import com.nrc7.mynews.adapters.NewsListener;
import com.nrc7.mynews.models.Articles;
import com.nrc7.mynews.models.Wrapper;
import com.nrc7.mynews.services.GetAllArticles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NewsActivity extends AppCompatActivity implements NewsListener {

    private NewsAdapter newsAdapter;
    private RecyclerView newsRV;
    private TextView emptyListTV;
    private List<Articles> mArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        emptyListTV = findViewById(R.id.emptyListTv);
        newsRV = findViewById(R.id.booksRv);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        newsRV.setLayoutManager(manager);
        newsRV.setHasFixedSize(true);

        mArticles = (List<Articles>) getIntent().getSerializableExtra("list");


        ::newsAdapter = new NewsAdapter(mArticles, this);
        newsRV.setAdapter(newsAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //newsAdapter.addBook(new Book("hermanos kamarasov", "dowtoyeski"));
                //newsAdapter.deleteBook();
                //newsAdapter.clean();
                //2newsAdapter.reset();
                //newsAdapter.update(newsAdapter.getItemCount() - 1);
                if (newsAdapter.getItemCount() > 0) {
                    newsRV.smoothScrollToPosition(newsAdapter.getItemCount() - 1);
                    Toast.makeText(NewsActivity.this, "Funcionó", Toast.LENGTH_SHORT).show();
                } else {
                    emptyListTV.setVisibility(View.VISIBLE);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*HandCraft Click Listener From NewsAdapter */
    @Override
    public void clicked(int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void transporting(Articles articles) {
        Intent intent = new Intent(this, NewsDetailsActivity.class);
        intent.putExtra("article", articles);
        startActivity(intent);
    }
}
