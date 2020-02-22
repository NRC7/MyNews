package com.nrc7.mynews.adapters;

import com.nrc7.mynews.models.Book;

public interface NewsListener {

    // Just Debug, after test Rename or Remove
    void clicked(int position);

    void transporting(Book selectedBook);
}
