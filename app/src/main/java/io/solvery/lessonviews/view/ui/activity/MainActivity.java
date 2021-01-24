package io.solvery.lessonviews.view.ui.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();

    }

    private void initList() {
        RecyclerView rvItems = findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        rvItems.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL)); //this add divider between items
        //rvItems.addItemDecoration(new CustomItemDecoration()); //this add space between items
        new LinearSnapHelper().attachToRecyclerView(rvItems); //this add items center after scrolling

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

    private static class CustomItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            if (parent.getChildAdapterPosition(view) != 0)
                outRect.top = (int) view.getContext().getResources().getDimension(R.dimen.view_divider_height);
        }
    }

}