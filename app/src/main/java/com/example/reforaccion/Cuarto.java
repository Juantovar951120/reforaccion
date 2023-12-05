package com.example.reforaccion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cuarto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cuarto extends Fragment {


    public Cuarto() {
        // Required empty public constructor
    }


    public static Cuarto newInstance(String param1, String param2) {
        Cuarto fragment = new Cuarto();

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
        return inflater.inflate(R.layout.fragment_cuarto, container, false);
    }
}