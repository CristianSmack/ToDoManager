package com.cristiandevs.todomanager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cristiandevs.todomanager.Database.ToDoItemDB;
import com.cristiandevs.todomanager.Model.ToDoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment {
    RecyclerView recyclerView;
    ItemAdapter adapter;
    View view;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = view.findViewById(R.id.recyclerTodo);

        recyclerView.setLayoutManager(layoutManager);
        ToDoItemDB db = ToDoItemDB.getInstance(getActivity());
        ArrayList<ToDoItem> items = (ArrayList)db.toDoItemDAO().getAll();

        adapter = new ItemAdapter(items,getActivity());

        recyclerView.setAdapter(adapter);



        return view;
    }
}
