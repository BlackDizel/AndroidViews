package io.solvery.lessonviews.di.module;


import io.solvery.lessonviews.data.memorycache.CacheData;
import io.solvery.lessonviews.data.repository.RepositoryData;
import io.solvery.lessonviews.view.presenter.PresenterMain;
import toothpick.config.Module;

//https://github.com/stephanenicolas/toothpick/wiki/Modules-&-Bindings
public class ModuleActivityMain extends Module {
    public ModuleActivityMain() {
        bind(PresenterMain.class); //new instance every time
        bind(RepositoryData.class).toInstance(new RepositoryData()); //singletone in this scope
        bind(CacheData.class).toInstance(new CacheData()); //singletone in this scope
    }
}