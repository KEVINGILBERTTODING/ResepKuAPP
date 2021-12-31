package com.example.resepku;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread= new Thread(){
            public void run(){
                try {
                        sleep(4000);    //panjang waktu munculnya splash screen
                                            // dalam milisecond sebelum melakukan intent ke halaman MainActivity
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent goToMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(goToMainActivity);
                    finish();
                }
            }
        };
        thread.start();
    }
}