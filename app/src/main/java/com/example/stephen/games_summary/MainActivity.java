package com.example.stephen.games_summary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Initialize Fabric Kit
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);




        //This will be placed in the recycler adapter
        /*
        Picasso.with(this)
                .load("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png")
                .resize(500, 250)
                .centerCrop()
                .into(imageView);*/

//textView.setText("Nullpointer Exception Test");

    }
}
