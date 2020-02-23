package com.nrc7.mynews.services;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Interceptor {

    private static final String BASE_URL = "https://newsapi.org/v2/";

    NewsApi getAllArticles(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new okhttp3.Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder()
                        .addHeader("X-Api-Key", "8537b63a48074e909ac48e4771a4d2b4")
                        .build();

                Response response = chain.proceed(request);

                //If the request fail then you get 3 retrys
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }
                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        //Interface Class for this GET request
        return interceptor.create(NewsApi.class);
    }
}
