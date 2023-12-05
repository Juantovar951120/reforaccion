package com.example.reforaccion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Primero#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Primero extends Fragment {


    public Primero() {
        // Required empty public constructor
    }


    public static Primero newInstance(String param1, String param2) {
        Primero fragment = new Primero();

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
        return inflater.inflate(R.layout.fragment_primero, container, false);
    }
}