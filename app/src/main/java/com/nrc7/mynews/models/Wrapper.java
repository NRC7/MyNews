package com.nrc7.mynews.models;

import java.io.Serializable;

public class Wrapper implements Serializable {

    private String status;
    private int totalResults;
    private Article[] articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Article[] getArticles() {
        return articles;
    }
}
