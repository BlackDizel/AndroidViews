package io.solvery.lessonviews.data.network;

import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    @Inject
    public Api(){}

    private IApi api;

    public IApi getApi(){
        if (api != null) return api;

        Gson gson = new GsonBuilder()
                .create();

        api = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://www.example.com") //api url
                .client(getClient())
                .build()
                .create(IApi.class);

        return api;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new RequestInterceptor())  //add interceptor to
                // 1. set header auth token for every request
                // 2. update token if need
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
    }

    private class RequestInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            if (isTokenOutdated())
                setToken(getApi().getToken().execute().body());

            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", getToken())
                    .build();

            Response response = chain.proceed(request);
            return response;
        }
    }

    private void setToken(String token) {
        //todo store token in some cache
    }

    private String getToken() {
        //todo get token from cache
        return "";
    }

    private boolean isTokenOutdated() {
        return false;//todo return if token is outdated
    }
}
