package com.nrc7.mynews.utils;

import android.content.Intent;
import android.net.Uri;

import java.text.SimpleDateFormat;

public class Utilities {

    public static final String SPLASH_LIST_KEY = "list";
    public static final String DETAILS_KEY = "article";
    public static final String DEFAULT_IMAGE_URL = "https://images.unsplash.com/photo-1476242906366-d8eb64c2f661?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1308&q=80";

    public Intent goToSource(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,  uri);
        return intent;
    }

    public String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return String.valueOf(simpleDateFormat.format(System.currentTimeMillis()));
    }


}
