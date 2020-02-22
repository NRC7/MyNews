package com.nrc7.mynews.models;

public class Wrapper {

    private String status;
    private int totalResults;
    private Articles[] articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Articles[] getArticles() {
        return articles;
    }
}
