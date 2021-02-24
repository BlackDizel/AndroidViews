package io.solvery.lessonviews.view;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.lang.ref.WeakReference;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.view.ui.fragment.FragmentSome;

public class Navigator {

    private WeakReference<FragmentManager> refFragmentManager;
    private WeakReference<Activity> refActivity;

    private int layoutRes;

    public void set(Activity activity, FragmentManager fragmentManager, int layoutRes) {
        this.refFragmentManager = new WeakReference<>(fragmentManager);
        this.refActivity = new WeakReference<>(activity);
        this.layoutRes = layoutRes;
    }

    public void navigate(PageEnum page) {
        navigate(page, R.anim.up_activity_in_slide, R.anim.up_activity_out_slide);
    }

    private void navigate(PageEnum page, int enterAnim, int exitAnim) {
        if (refFragmentManager == null || refFragmentManager.get() == null) return;

        refFragmentManager.get()
                .beginTransaction()
                .setCustomAnimations(enterAnim, exitAnim)
                .replace(layoutRes, getFragment(page))
                .commitAllowingStateLoss();
    }

    private Fragment getFragment(PageEnum page) {
        switch (page) {
            case SOMEPAGE:
                return new FragmentSome();
        }
        return null;
    }

}
