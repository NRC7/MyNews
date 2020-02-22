package com.nrc7.mynews.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nrc7.mynews.R;
import com.nrc7.mynews.models.Book;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        TextView textView = findViewById(R.id.detailsNameTv);

        Book detailsbook = (Book) getIntent().getSerializableExtra("book");
        if (detailsbook.getAuthor() != null) {
            textView.setText(detailsbook.getAuthor());
        }
    }
}