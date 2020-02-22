package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.models.Wrapper;
import com.nrc7.mynews.services.GetAllArticles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SplashActivity extends AppCompatActivity {

    List<Article> articles;
    int splashTimer = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (articles == null || articles.size() < 1) {
            articles = new Utilities().getAllArticles();
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra(Utilities.SPLASH_LIST_KEY, (Serializable) articles);
                startActivity(intent);
            }
        }, splashTimer);
    }
}
