package io.solvery.lessonviews.data.repository;

import javax.inject.Inject;

import io.solvery.lessonviews.data.memorycache.CacheData;
import io.solvery.lessonviews.data.network.Api;
import io.solvery.lessonviews.di.ScopeEnum;
import io.solvery.lessonviews.di.ScopeHelper;
import io.solvery.lessonviews.model.SomeModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryData {

    @Inject
    CacheData cacheData;

    @Inject
    Api api;

    private Call<SomeModel> request;

    @Inject
    public RepositoryData() {
        ScopeHelper.getScope(ScopeEnum.ACTIVITY_MAIN).inject(this);
    }

    public void request() {
        if (request != null)
            request.cancel();

        request = api.getApi().getData("something");
        request.enqueue(new Callback<SomeModel>() {

            @Override
            public void onResponse(Call<SomeModel> call, Response<SomeModel> response) {
                if (response.isSuccessful())
                    cacheData.setData(response.body().getData());
            }

            @Override
            public void onFailure(Call<SomeModel> call, Throwable t) {

            }
        });
    }
}

