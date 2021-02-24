package io.solvery.lessonviews.view.presenter;

import java.util.List;

import javax.inject.Inject;

import io.solvery.lessonviews.data.memorycache.CacheData;
import io.solvery.lessonviews.data.memorycache.listener.ICacheDataListener;
import io.solvery.lessonviews.data.repository.RepositoryData;
import io.solvery.lessonviews.di.ScopeEnum;
import io.solvery.lessonviews.di.ScopeHelper;
import io.solvery.lessonviews.view.presenter.listener.IPresenterMainListener;

public class PresenterMain implements ICacheDataListener {

    @Inject
    RepositoryData repositoryData;

    @Inject
    CacheData cacheData;

    private IPresenterMainListener listener;

    @Inject
    public PresenterMain() {
        ScopeHelper.getScope(ScopeEnum.ACTIVITY_MAIN).inject(this);
        cacheData.addListener(this);
    }

    public void onClickTitle() {
        repositoryData.request();
    }

    @Override
    public void onUpdate() {
        listener.setText(mapData(cacheData.getData()));
    }

    private String mapData(List<String> data) {
        //some mapping
        return data == null || data.size() == 0 ? "" : data.get(0);
    }

    public void onCreate(IPresenterMainListener listener) {
        this.listener = listener;
    }
}
