package io.solvery.lessonviews.view.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.di.ScopeEnum;
import io.solvery.lessonviews.di.ScopeHelper;
import io.solvery.lessonviews.di.module.ModuleActivityMain;
import io.solvery.lessonviews.view.Navigator;
import io.solvery.lessonviews.view.presenter.PresenterMain;
import io.solvery.lessonviews.view.presenter.listener.IPresenterMainListener;

public class ActivityMain extends AppCompatActivity
        implements View.OnClickListener, IPresenterMainListener {

    //to read acrhitertures
    //MVC -> MVP -> MVVM
    //VIPER, Redux, MVI
    //SOLID -> CLEAN

    @Inject
    PresenterMain presenter;

    @Inject
    Navigator navigator;

    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //here DI injects presenter
        ScopeHelper.getScope(ScopeEnum.ACTIVITY_MAIN)
                .installModules(new ModuleActivityMain())
                .inject(this);

        setContentView(R.layout.activity_main);

        presenter.onCreate(this);
        navigator.set(this, getSupportFragmentManager(), R.id.flContainer);

        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvTitle)
            presenter.onClickTitle();

        //todo or navigator.navigate(PageEnum.somePage);
    }

    @Override
    public void setText(String text) {
        tvTitle.setText(text);
    }

}