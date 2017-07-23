package com.example.kazz.quick_chat_project;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kazz on 23/07/17.
 */

public class Ecoline extends android.support.v4.app.Fragment{
    public Ecoline() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ecoline, container, false);
        return view;
    }
}
