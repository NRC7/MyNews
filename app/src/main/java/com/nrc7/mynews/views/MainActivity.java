package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.nrc7.mynews.R;
import com.nrc7.mynews.adapters.NewsAdapter;
import com.nrc7.mynews.models.Articles;
import com.nrc7.mynews.models.Wrapper;
import com.nrc7.mynews.services.GetAllArticles;
import com.nrc7.mynews.views.NewsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    List<Articles> mArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mArticles = getAllArticles();
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("list", (Serializable) mArticles);
                startActivity(intent);
            }
        }, 1800);
    }

    public List<Articles> getAllArticles(){

        List<Articles> articlesList = new ArrayList<>();

        try {
            Wrapper wrapper = new AllArticlesSer().execute().get();
            Articles[] response = wrapper.getArticles();
            articlesList = Arrays.asList(response);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return articlesList;
    }

    private static class AllArticlesSer extends GetAllArticles {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("MRZUTIL", "onPreExecute()");
        }

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            super.onPostExecute(wrapper);
            Log.d("MRZUTIL", "onPostExecute(Wrapper wrapper)");
        }
    }
}
