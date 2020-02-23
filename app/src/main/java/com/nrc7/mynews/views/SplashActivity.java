package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.services.GetArticles;
import com.nrc7.mynews.utils.Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    List<Article> articles = new ArrayList<>();
    int splashTimer = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        articles = new GetArticles().getArticleList();
        if (articles.size() > 1) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                    intent.putExtra(Utilities.SPLASH_LIST_KEY, (Serializable) articles);
                    startActivity(intent);
                }
            }, splashTimer);
        } else {
            Toast.makeText(this, "Intentalo Nuevamente", Toast.LENGTH_SHORT).show();
        }
    }
}
