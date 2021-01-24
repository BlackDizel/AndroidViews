package io.solvery.lessonviews.view.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.solvery.lessonviews.R;

public class FragmentDetails extends Fragment {

    public static final String EXTRA_ID = "id";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        String data = getArguments().getString(EXTRA_ID);
        ((TextView) view.findViewById(R.id.tvName)).setText(data);
    }
}
