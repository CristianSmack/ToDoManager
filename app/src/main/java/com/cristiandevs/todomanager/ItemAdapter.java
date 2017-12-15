package com.cristiandevs.todomanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cristiandevs.todomanager.Model.ToDoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 15/12/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<ToDoItem> mItems;

    public ItemAdapter(ArrayList items) {
        mItems = items;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, final int position) {
        holder.title.setText(mItems.get(position).getName());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAt(position);
            }
        });
        if(mItems.get(position).isDone())
            holder.checkBox.setChecked(true);
        else
            holder.checkBox.setChecked(false);
       /* holder.moreButton.setOnClickListener(view -> updateItem(position));
        holder.deleteButton.setOnClickListener(view -> removerItem(position));*/
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public void removeAt(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mItems.size());
    }

}
