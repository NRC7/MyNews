package com.nrc7.mynews.adapters;

import com.nrc7.mynews.models.Article;

import java.util.List;

public interface NewsListener {

    void toDetails(Article article);

    void update(List<Article> articles);
}
