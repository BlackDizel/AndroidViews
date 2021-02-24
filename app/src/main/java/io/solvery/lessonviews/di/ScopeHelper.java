package io.solvery.lessonviews.di;

import toothpick.Scope;
import toothpick.Toothpick;

public final class ScopeHelper {

    public static Scope getScope(ScopeEnum scope) {
        Scope result = scope.getParent() == null
                ? Toothpick.openRootScope()
                : getScope(scope.getParent());

        result.openSubScope(scope);

        return result;
    }

}