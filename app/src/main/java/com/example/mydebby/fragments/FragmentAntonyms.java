package com.example.mydebby.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mydebby.R;
import com.example.mydebby.WordMeaningActivity;

public class FragmentAntonyms extends Fragment {
    public FragmentAntonyms() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_definition,container, false);// inflate the layout
        Context context = getActivity();
        TextView text = view.findViewById(R.id.textViewD);
        String antonyms = ((WordMeaningActivity)context).antonyms;
        if (antonyms!=null) {
            antonyms = antonyms.replaceAll(",", ",\n");
            text.setText(antonyms);
        }
        if (antonyms == null){
            text.setText("No antonyms found");
        }
        return view;
    }
}
