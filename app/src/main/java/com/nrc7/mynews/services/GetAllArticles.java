package com.nrc7.mynews.services;

import android.os.AsyncTask;
import android.util.Log;

import com.nrc7.mynews.models.Wrapper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllArticles extends AsyncTask<Wrapper, Void, Wrapper> {
    @Override
    protected Wrapper doInBackground(Wrapper... wrappers) {

        NewsApi articlesApi = new Services().getAllArticles();
        Call<Wrapper> call = articlesApi.getArticles();
        Log.d("MRZUTIL", "HACIENDO EL CALL");

        try {
            Response<Wrapper> response = call.execute();
            if (200 == response.code()){
                Log.d("MRZUTIL", "TIENE QUE SER 200: " + response.code());
                Log.d("MRZUTIL", "LONGUITUD: " + response.body().getTotalResults());
                Log.d("", "");
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
