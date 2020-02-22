package com.nrc7.mynews.services;

import com.nrc7.mynews.models.Wrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {

    String QUERY = "top-headlines?sources=google-news,abc-news,cnn-es,espn,football-italia,fox-sports,google-news-ar,hacker-news,ign,marca,mtv-news,national-geographic,nfl-news,the-new-york-times,the-next-web,the-sport-bible,the-washington-post,wired&apiKey=8537b63a48074e909ac48e4771a4d2b4";

    @GET(QUERY)
    Call<Wrapper> getArticles();
}
