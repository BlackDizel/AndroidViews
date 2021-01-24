package io.solvery.lessonviews.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.model.SampleData;

public class AdapterItems extends RecyclerView.Adapter<AdapterItems.ViewHolderItem> {

    private List<SampleData> data;

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderItem(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItem holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void updateData(List<SampleData> data) {
        this.data = data;
        notifyDataSetChanged();
        //notifyItemChanged();
        //notifyItemInserted();
        //notifyItemRemoved();
    }


    class ViewHolderItem extends RecyclerView.ViewHolder {

        private final TextView tvName, tvNumber;

        public ViewHolderItem(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }

        public void setData(int position) {
            tvName.setText(data.get(position).text);
            tvNumber.setText(String.valueOf(data.get(position).number));
        }
    }
}
