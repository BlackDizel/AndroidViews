package io.solvery.lessonviews.view.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.model.SampleData;
import io.solvery.lessonviews.view.adapter.AdapterItems;

public class FragmentList extends Fragment {

    private AdapterItems adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        initList(view);
    }

    private void initList(View view) {
        RecyclerView rvItems = view.findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(view.getContext()));
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
