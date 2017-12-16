package com.cristiandevs.todomanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cristiandevs.todomanager.Model.ToDoItem;

/**
 * Created by Cristian on 15/12/2017.
 */

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public CheckBox checkBox;
    public View itemView;

    public LineHolder(View itemView){
        super(itemView);
        title = itemView.findViewById(R.id.textView);
        checkBox = itemView.findViewById(R.id.done);

        this.itemView = itemView;

    }
}
