package com.example.reforaccion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tercero#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tercero extends Fragment {



    public Tercero() {
        // Required empty public constructor
    }


    public static Tercero newInstance(String param1, String param2) {
        Tercero fragment = new Tercero();

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
        return inflater.inflate(R.layout.fragment_tercero, container, false);
    }
}