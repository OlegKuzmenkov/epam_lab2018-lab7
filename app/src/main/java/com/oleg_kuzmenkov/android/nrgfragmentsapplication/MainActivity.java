package com.oleg_kuzmenkov.android.nrgfragmentsapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    private final String TAG = "Message";
    private final String FIRST_FRAGMENT = "class com.oleg_kuzmenkov.android.nrgfragmentsapplication.MyFirstFragment";
    private final String SECOND_FRAGMENT = "class com.oleg_kuzmenkov.android.nrgfragmentsapplication.MySecondFragment";

    private Button mStartNextFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity: onCreate()");

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

            if (fragment == null) {
                fragment = new MyFirstFragment();
                fm.beginTransaction().add(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
            }
        }

        mStartNextFragmentButton = findViewById(R.id.start_next_fragment_button);

        if(savedInstanceState!= null && (savedInstanceState.getBoolean("index") == false)) {
            mStartNextFragmentButton.setEnabled(false);
        }
        mStartNextFragmentButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Log.d(TAG, "Activity: startNextFragment!");
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

                if(FIRST_FRAGMENT.equalsIgnoreCase(fragment.getClass().toString())){
                    fragment = new MySecondFragment();
                    fm.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
                }
                else
                    if(SECOND_FRAGMENT.equalsIgnoreCase(fragment.getClass().toString())){
                        fragment = new MyThirdFragment();
                        fm.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
                        mStartNextFragmentButton.setEnabled(false);
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity: onDestroy()");
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        }
        else {
            mStartNextFragmentButton.setEnabled(true);
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Activity: onSaveInstanceState");
        if(mStartNextFragmentButton.isEnabled() == false) {
            outState.putBoolean("index", false);
        }
        else {
            outState.putBoolean("index", true);
        }
    }
}
