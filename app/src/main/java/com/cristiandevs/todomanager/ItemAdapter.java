package com.cristiandevs.todomanager;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cristiandevs.todomanager.Database.ToDoItemDB;
import com.cristiandevs.todomanager.Model.ToDoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 15/12/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<ToDoItem> mItems;
    private Activity context;

    public ItemAdapter(ArrayList items, Activity context) {
        mItems = items;
        this.context=context;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailFragment detailFragment = DetailFragment.newInstance(mItems.get(position));
                context.getFragmentManager().beginTransaction().add(R.id.fragment,detailFragment).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public void removeAt(int position) {
        ToDoItemDB toDoItemDB = ToDoItemDB.getInstance(context);
        toDoItemDB.toDoItemDAO().delete(mItems.get(position));
        mItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mItems.size());
    }
}
