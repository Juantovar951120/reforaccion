package com.example.reforaccion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Quinto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quinto extends Fragment {



    public Quinto() {
        // Required empty public constructor
    }


    public static Quinto newInstance(String param1, String param2) {
        Quinto fragment = new Quinto();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quinto, container, false);
    }
}