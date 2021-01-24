package io.solvery.lessonviews.view.ui.activity;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.model.SampleData;
import io.solvery.lessonviews.view.adapter.AdapterItems;

public class MainActivity extends AppCompatActivity {
    private AdapterItems adapter;

    //build.gradle
    //recycleViews
    //активити и фрагменты
    //навигация активити и фрагменты, передача параметров
    //constraintlayout
    //методы жизненного цикла
    //рантайм першмишен
    //сервисы
    //mvp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();

    }

    private void initList() {
        RecyclerView rvItems = findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        //rvItems.addItemDecoration(); todo add divider
        //todo add snap
        //todo GridLayoutManager
         adapter = new AdapterItems();
        rvItems.setAdapter(adapter);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.updateData(getData());
            }
        }, 2000);

    }

    private List<SampleData> getData() {
        ArrayList<SampleData> result = new ArrayList<>();
        result.add(new SampleData("HEADER", 0)); //todo refactor to subtype
        result.add(new SampleData("Vasya", 3));
        result.add(new SampleData("Masha", 5));
        result.add(new SampleData("Petya", 3));
        result.add(new SampleData("Kirill", 4));
        result.add(new SampleData("Nastya", 6));
        result.add(new SampleData("Katya", 7));
        result.add(new SampleData("Anna", 1));
        return result;
    }
}