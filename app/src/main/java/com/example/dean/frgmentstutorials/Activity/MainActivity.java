package com.example.dean.frgmentstutorials.Activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dean.frgmentstutorials.Fragments.AboutFragment;
import com.example.dean.frgmentstutorials.Fragments.MainFragment;
import com.example.dean.frgmentstutorials.Fragments.PickpowerFragment;
import com.example.dean.frgmentstutorials.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickpowerFragment.PickPowerInteractionListener, AboutFragment.OnAboutFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (savedInstanceState == null) {
            fragment = new MainFragment();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        }


    }

    public void loadPickPowerScreen() {
        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = manager.findFragmentById(R.id.fragment_container);


        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PickpowerFragment()).addToBackStack(null).commit();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);




        fragmentTransaction.commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onAboutFragmentInteraction(String TAG, Object data) {

        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).addToBackStack(null).commit();

       /* if (TAG.equals("BLANK")){
            Toast.makeText(this, "BLANKK FRAGMENT", Toast.LENGTH_SHORT).show();
        }
        else if (TAG.equals("TAGFragment2")){
            //Do something with 'data' that comes from fragment2
        }*/
    }
}
