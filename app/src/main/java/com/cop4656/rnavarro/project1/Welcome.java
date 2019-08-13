// Ruben Navarro
// 06/04/2019
// COP 4656
// Project 1 - Tic Tac Nole
// RN16G

package com.cop4656.rnavarro.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.media.MediaPlayer;

public class Welcome extends AppCompatActivity {


    private MediaPlayer mp, mp2;
    private TextView text;
    private Button p2button, cpubutton;
    String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        text = findViewById(R.id.textView4);
        p2button = findViewById(R.id.button12);
        cpubutton = findViewById(R.id.button11);
        mp = MediaPlayer.create(this, R.raw.p2_start);
        mp2 = MediaPlayer.create(this, R.raw.cpu_start);

        // handler object to handle post delays
        final Handler handler = new Handler();

        // displays displaying tic tac nole to screen for better visuals
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setText("TO");
            }
        }, 2000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setText("TIC");
            }
        }, 3500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setText("TAC");
            }
        }, 4500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setText("NOLE");
            }
        }, 5500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setText("TIC TAC NOLE!");
            }
        }, 7000);

        // if player 2 is chosen, starts music, sets choice to p2, and switches to main activity
        p2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                choice = "p2";
                switchToMain();
            }
        });
        // if cpu is chosen, starts music, sets choice to cpu, and switches to main activity
        cpubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.start();
                choice = "cpu";
                switchToMain();
            }
        });
    }
    // function to switch activity to main activity with game logic
    public void switchToMain() {
    Intent intent = new Intent (Welcome.this, MainActivity.class);
    intent.putExtra("key", choice);
    startActivity(intent);
    }
}
