package com.oleg_kuzmenkov.android.nrgfragmentsapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;


public class MyThirdFragment extends Fragment {

    private int mRandomColor;
    private final String TAG = "Message";

    public MyThirdFragment(){
        Log.d(TAG, "Fragment: Default Constructor!");
    }

    @Override
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Fragment: onCreate()");
        if(savedInstanceState == null){
            mRandomColor = getRandomColor();
        }
        else{
            mRandomColor = savedInstanceState.getInt("index");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        Log.d(TAG, "Fragment: onCreateView()");
        v.setBackgroundColor(mRandomColor);
        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Fragment: onSaveInstanceState");
        outState.putInt("index", mRandomColor);
    }

    /**
     * Generate random color
     */
    private int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}

