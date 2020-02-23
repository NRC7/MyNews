package com.nrc7.mynews.views;

import android.util.Log;
import android.widget.ImageView;

import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.models.Wrapper;
import com.nrc7.mynews.services.GetAllArticles;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Utilities {

    public static final String SPLASH_LIST_KEY = "list";
    public static final String DETAILS_KEY = "article";
    public static final String DEFAULT_IMAGE_URL = "https://images.unsplash.com/photo-1476242906366-d8eb64c2f661?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1308&q=80";

    public List<Article> getAllArticles(){

        List<Article> articleList = new ArrayList<>();

        try {
            Wrapper wrapper = new AllArticles().execute().get();
            Article[] response = wrapper.getArticles();
            articleList = Arrays.asList(response);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    public void initLogo(ImageView imageView, String url) {
        if (imageView != null && url != null) {
            Picasso.get()
                    .load(url)
                    .into(imageView);
            Log.d("NRC7", "initLogo: IMAGE OK");
        } else {
            Log.d("NRC7", "initLogo: IMAGE NULL");
        }
    }

    public String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return String.valueOf(simpleDateFormat.format(System.currentTimeMillis()));
    }

    private static class AllArticles extends GetAllArticles {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("NRC7", "onPreExecute()");
        }

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            super.onPostExecute(wrapper);
            Log.d("NRC7", "onPostExecute(Wrapper wrapper)");
        }
    }
}
