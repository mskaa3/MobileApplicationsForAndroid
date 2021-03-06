package com.example.lab4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DynamicFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int counter=0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DynamicFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DynamicFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static DynamicFragment2 newInstance(String param1, String param2) {
        DynamicFragment2 fragment = new DynamicFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dynamic2, container, false);
        Button button1=view.findViewById(R.id.counter);
        TextView textV=view.findViewById(R.id.counterText);

        if(savedInstanceState!=null){

            (new Exception()).printStackTrace();
            counter=savedInstanceState.getInt("Clicks");
            textV.setText(Integer.toString(counter));
        }


        button1.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        counter+=1;
        textV.setText(Integer.toString(counter));
    }
});
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("Clicks",counter);
    }

}