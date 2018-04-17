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


public class MyFirstFragment extends Fragment {

    private int mRandomColor;
    private final String TAG = "Message";

    public MyFirstFragment(){
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
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Log.d(TAG, "Fragment: onCreateView()");
        v.setBackgroundColor(mRandomColor);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment: onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment: onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment: onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment: onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment: onDestroy()");
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
