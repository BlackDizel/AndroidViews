package io.solvery.lessonviews.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.solvery.lessonviews.R;
import io.solvery.lessonviews.model.SampleData;

public class AdapterItemsTwoTypes extends RecyclerView.Adapter<AdapterItemsTwoTypes.ViewHolderItemBase> {

    private List<SampleData> data;

    private int TYPE_UNKNOWN = 0;
    private int TYPE_HEADER = 1;
    private int TYPE_ITEM = 2;

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    @NonNull
    @Override
    public ViewHolderItemBase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER)
            return new ViewHolderHeader(parent);
        return new ViewHolderItem(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItemBase holder, int position) {
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

    abstract static class ViewHolderItemBase extends RecyclerView.ViewHolder {

        public ViewHolderItemBase(@NonNull View itemView) {
            super(itemView);
        }

        abstract public void setData(int position);
    }

    class ViewHolderItem extends ViewHolderItemBase {

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

    static class ViewHolderHeader extends ViewHolderItemBase {

        public ViewHolderHeader(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false));
        }

        public void setData(int position) {
        }
    }
}
