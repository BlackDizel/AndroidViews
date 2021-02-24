package io.solvery.lessonviews.di.module;

import io.solvery.lessonviews.data.network.Api;
import io.solvery.lessonviews.view.Navigator;
import toothpick.config.Module;

//https://github.com/stephanenicolas/toothpick/wiki/Modules-&-Bindings
public class ModuleApp extends Module {
    public ModuleApp() {
        bind(Navigator.class).toInstance(new Navigator());
        bind(Api.class).toInstance(new Api());
    }
}
