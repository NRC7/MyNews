package com.nrc7.mynews.views;

import android.util.Log;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.models.Wrapper;
import com.nrc7.mynews.services.GetAllArticles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Utilities {

    public static final String SPLASH_LIST_KEY = "list";

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
