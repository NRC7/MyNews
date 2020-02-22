package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        TextView textView = findViewById(R.id.detailsNameTv);

        Article detailsArticle = (Article) getIntent().getSerializableExtra("article");
        if (detailsArticle.getDescription() != null) {
            textView.setText(detailsArticle.getDescription());
        }
    }
}
