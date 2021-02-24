package io.solvery.lessonviews.view;

import android.app.Application;

import io.solvery.lessonviews.di.ScopeEnum;
import io.solvery.lessonviews.di.ScopeHelper;
import io.solvery.lessonviews.di.module.ModuleApp;

public class Core extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ScopeHelper.getScope(ScopeEnum.APP)
                .installModules(new ModuleApp())
                .inject(this);

    }
}
