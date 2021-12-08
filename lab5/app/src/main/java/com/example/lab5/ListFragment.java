package com.example.lab5;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab5.placeholder.PlaceholderContent;

import java.util.List;

public class ListFragment extends Fragment {
    private ListFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private MyRVAdapter mAdapter;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListFragment newInstance(int columnCount) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        if( (context instanceof ListFragmentInteractionListener))
            mListener = (ListFragmentInteractionListener) context;
        else
            throw new RuntimeException(context.toString() + "must implement ListFragmentInteractionListener");
    }
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    void setList(List<ItemData> list) {
        mAdapter.setItemList(list);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        //bellow the optional code (for one case):
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            mRecyclerView = (RecyclerView) view;
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        //end of the optional code
        return view;
    }


}