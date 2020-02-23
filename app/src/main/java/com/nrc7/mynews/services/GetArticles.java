package com.nrc7.mynews.services;

import android.util.Log;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.models.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GetArticles {

    private List<Article> articleList = getAllArticles();

    public List<Article> getArticleList() {
        return articleList;
    }

    private List<Article> getAllArticles(){

        List<Article> articleList = new ArrayList<>();

        try {
            Wrapper wrapper = new ArticlesArticleService().execute().get();
            Article[] response = wrapper.getArticles();
            articleList = Arrays.asList(response);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    private static class ArticlesArticleService extends ArticleService {

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
