package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

public class NewsDetailsActivity extends AppCompatActivity {

    TextView publishedAtTv, authorTv, titleTv;
    ImageView detailsImageView;
    Utilities utilities;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        publishedAtTv = findViewById(R.id.detailsPublishedAtTv);
        authorTv = findViewById(R.id.detailsAuthorTv);
        titleTv = findViewById(R.id.detailsTitleTv);
        detailsImageView = findViewById(R.id.detailsImageView);
        utilities = new Utilities();

        Article detailsArticle = (Article) getIntent().getSerializableExtra(Utilities.DETAILS_KEY);

        String date = detailsArticle.getPublishedAt();
        if (date != null) {
            //publishedAtTv.setText(date);
            String currentDate = utilities.getCurrentDate();
            publishedAtTv.setText(currentDate);
        } else {
            String currentDate = utilities.getCurrentDate();
            publishedAtTv.setText(currentDate);
        }

        String author = detailsArticle.getAuthor();
        if (author != null) {
            authorTv.setText(author);
        } else {
            authorTv.setText("to be confirmed");
        }

        String title = detailsArticle.getTitle();
        if (title != null) {
            titleTv.setText(title);
        } else {
            titleTv.setText("Go To Source");
        }

        String url = detailsArticle.getUrlToImage();
        if (url != null) {
            Picasso.get().load(url).into(detailsImageView);
        } else {
            Picasso.get().load(Utilities.DEFAULT_IMAGE_URL).into(detailsImageView);
        }
    }
}
