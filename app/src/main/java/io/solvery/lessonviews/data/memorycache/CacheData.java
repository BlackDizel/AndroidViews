package io.solvery.lessonviews.data.memorycache;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.solvery.lessonviews.data.memorycache.listener.ICacheDataListener;

public class CacheData {

    @Inject
    public CacheData(){}

    private List<String> data;
    private ArrayList<WeakReference<ICacheDataListener>> listeners;

    public void setData(List<String> data) {
        this.data = data;
        notifyListeners();
    }

    private void notifyListeners() {
        if (listeners == null) return;
        for (WeakReference<ICacheDataListener> listener : listeners)
            if (listener != null && listener.get() != null)
                listener.get().onUpdate();
    }

    public void addListener(ICacheDataListener listener) {
        if (listeners == null) listeners = new ArrayList<>();
        this.listeners.add(new WeakReference<>(listener));
    }

    public List<String> getData() {
        return data;
    }
}
