package com.nrc7.mynews.models;

import java.io.Serializable;

public class Wrapper implements Serializable {

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
