package com.cristiandevs.todomanager;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cristiandevs.todomanager.Model.ToDoItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_ITEM = "item";

    // TODO: Rename and change types of parameters
    private ToDoItem item;


    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param item Parameter 1.
     * @return A new instance of fragment DetailFragment.
     */
    public static DetailFragment newInstance(ToDoItem item) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = (ToDoItem) getArguments().getSerializable(ARG_PARAM_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView name = view.findViewById(R.id.nameView);
        TextView description = view.findViewById(R.id.descriptionView);
        TextView date = view.findViewById(R.id.dateView);

        name.setText(item.getName());
        description.setText(item.getDescription());

        SimpleDateFormat format = new SimpleDateFormat(
                "HH:mm:ss dd-MM-yyyy ");

        date.setText(format.format(item.getDate()));

        return view;
    }
}
