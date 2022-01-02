package com.example.resepku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread= new Thread(){
            public void run(){
                try {
                        sleep(7000);    //panjang waktu munculnya splash screen
                                            // dalam milisecond sebelum melakukan intent ke halaman MainActivity
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent goToMainActivity = new Intent(SplashScreen.this, firstActivity.class);
                    startActivity(goToMainActivity);
                    finish();
                }
            }
        };
        thread.start();
    }
}