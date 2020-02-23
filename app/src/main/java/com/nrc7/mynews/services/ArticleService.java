package com.nrc7.mynews.services;

import android.os.AsyncTask;
import com.nrc7.mynews.models.Wrapper;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class ArticleService extends AsyncTask<Wrapper, Void, Wrapper> {

    @Override
    protected Wrapper doInBackground(Wrapper... wrappers) {

        NewsApi articlesApi = new Interceptor().getAllArticles();
        Call<Wrapper> call = articlesApi.getArticles();

        try {
            Response<Wrapper> response = call.execute();
            if (200 == response.code()){
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
