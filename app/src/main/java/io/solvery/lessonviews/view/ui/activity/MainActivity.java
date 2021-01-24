package io.solvery.lessonviews.view.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.view.ui.fragment.FragmentDetails;
import io.solvery.lessonviews.view.ui.fragment.FragmentList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, new FragmentList())
                .commit();

    }

    public void showDetails(String text) {

        FragmentDetails fragment = new FragmentDetails();

        Bundle params = new Bundle();
        params.putString(FragmentDetails.EXTRA_ID, text);
        fragment.setArguments(params);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}