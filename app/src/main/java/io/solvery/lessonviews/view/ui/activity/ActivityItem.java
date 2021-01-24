package io.solvery.lessonviews.view.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.solvery.lessonviews.R;

public class ActivityItem extends AppCompatActivity {

    public static final String EXTRA_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        initData();

    }

    private void initData() {
        String name = getIntent().getExtras().getString(EXTRA_ID);
        ((TextView)findViewById(R.id.tvName)).setText(name);
    }
}
