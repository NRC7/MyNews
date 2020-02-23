package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Article;
import com.nrc7.mynews.utils.Utilities;
import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    NestedScrollView detailsLayout;
    TextView publishedAtTv, authorTv, titleTv, descriptionTv;
    ImageView detailsImageView;
    Utilities utilities;
    private Article detailsArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        publishedAtTv = findViewById(R.id.detailsPublishedAtTv);
        titleTv = findViewById(R.id.detailsTitleTv);
        descriptionTv = findViewById(R.id.detailsDescriptionTv);
        detailsImageView = findViewById(R.id.detailsImageView);
        authorTv = findViewById(R.id.detailsAuthorTv);
        detailsLayout = findViewById(R.id.detailsLayout);

        utilities = new Utilities();

        detailsArticle = (Article) getIntent().getSerializableExtra(Utilities.DETAILS_KEY);

        String url = detailsArticle.getUrlToImage();
        if (url != null) {
            Picasso.get().load(url).into(detailsImageView);
        } else {
            Picasso.get().load(Utilities.DEFAULT_IMAGE_URL).into(detailsImageView);
        }

        String date = detailsArticle.getPublishedAt();
        if (date != null) {
            publishedAtTv.setText(date);
        } else {
            String currentDate = utilities.getCurrentDate();
            publishedAtTv.setText(currentDate);
        }

        String title = detailsArticle.getTitle();
        if (title != null) {
            titleTv.setText(title);
        } else {
            titleTv.setText("Go To Source");
        }

        String body = detailsArticle.getDescription();
        if (body != null) {
            descriptionTv.setText(body);
        } else {
            descriptionTv.setVisibility(View.INVISIBLE);
        }

        String author = "By " + detailsArticle.getAuthor() + ", " + detailsArticle.getSource().getName();
        authorTv.setText(author);

        final String urlToSource = detailsArticle.getUrl();
        detailsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(utilities.goToSource(urlToSource));
                Toast.makeText(NewsDetailsActivity.this, "To Source" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
