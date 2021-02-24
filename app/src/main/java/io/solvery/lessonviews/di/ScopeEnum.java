package io.solvery.lessonviews.di;

import io.solvery.lessonviews.view.Core;
import io.solvery.lessonviews.view.ui.activity.ActivityMain;

public enum ScopeEnum {
    APP(Core.class, null),
    ACTIVITY_MAIN(ActivityMain.class, APP);

    private final ScopeEnum parent;

    ScopeEnum(Class _class, ScopeEnum parent) {
        this.parent = parent;
    }

    public ScopeEnum getParent() {
        return parent;
    }
}
