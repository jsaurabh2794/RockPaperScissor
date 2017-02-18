package com.example.saurabhsinghrajput.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by SAURABH SINGH RAJPUT on 16-09-2016.
 */
public class splashclass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);


        Handler hnd=new Handler();
        hnd.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(splashclass.this,MainActivity.class));
                finish();

            }
        },6000);
    }
}
