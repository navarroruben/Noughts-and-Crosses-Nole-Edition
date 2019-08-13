// Ruben Navarro
// 06/04/2019
// COP 4656
// Project 1 - Tic Tac Nole
// RN16G

package com.cop4656.rnavarro.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.List;
import java.util.ArrayList;
import android.media.MediaPlayer;
import android.os.Handler;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // objects for buttons, random, textview, and mediaplayer operations
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, pa;
    private Random rand = new Random();
    private TextView tv, tv1;
    private MediaPlayer mp3, mp4, mp5, mp6, mp7, mp8;

    // boolean variables for allows and unallowing operations
    boolean winner = false;
    boolean proceed = false;
    boolean gameover = false;

    // string variable to hold turn of game participants
    String choice = "";

    // variable to randomly choose who will start the match
    int selection = rand.nextInt(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // intent value passed from welcome activity in order to clarify if player 2 or cpu will player against player 1
        Intent intent = getIntent();
        choice = intent.getStringExtra("key");

        // button assign for respective buttons
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        pa = findViewById(R.id.button10);
        tv = findViewById(R.id.textView);
        tv1 = findViewById(R.id.textView1);

        // assigns respective sound files to media objects
        mp3 = MediaPlayer.create(this, R.raw.x_placement);
        mp4 = MediaPlayer.create(this, R.raw.o_placement);
        mp5 = MediaPlayer.create(this, R.raw.play_again);
        mp6 = MediaPlayer.create(this, R.raw.win);
        mp7 = MediaPlayer.create(this, R.raw.draw);
        mp8 = MediaPlayer.create(this, R.raw.robot_placement);

        // based on random selection, displays who will choose first to screen
        if (selection == 0)
            tv.setText("PLAYER 1: CHOOSE WISELY");
      else if (selection == 1 && choice.equals("p2"))
           tv.setText("PLAYER 2: CHOOSE TACTFULLY");
      else if (selection == 1 && choice.equals("cpu")) {
            tv.setText("UNSEEN ANDROID 24 IS SELECTING");
            androidMove();
            switchPlayer(selection);
        }

        // if col 1 row 1 is clicked by player1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false){
                    checkBox(b1);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 2 row 1 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b2);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 3 row 1 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b3);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 1 row 2 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b4);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 2 row 2 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b5);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 3 row 2 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b6);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 1 row 3 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b7);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 2 row 3 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b8);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // if col 3 row 3 is clicked by player 1 or player 2, checks if box is empty, checks if qualified to win,
        // switches player is flags are unaltered
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover == false) {
                    checkBox(b9);
                    checkWinner();
                    if (winner == false && proceed == true)
                        switchPlayer(selection);
                }
            }
        });
        // If play again button is clicked flags are reset, music plays, random player is reselected, and all text set back to empty
        pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp5.start();
                gameover = false;
                winner = false;
                proceed = false;
                selection = rand.nextInt(2);

                if (selection == 0)
                    tv.setText("PLAYER 1: CHOOSE WISELY");
                else if (selection == 1 && choice.equals("p2"))
                    tv.setText("PLAYER 2: CHOOSE TACTFULLY");
                else if (selection == 1 && choice.equals("cpu")) {
                    tv.setText("UNSEEN ANDROID 24 IS SELECTING");
                    switchPlayer(selection);
                }

                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");

            }
        });
    }
    // function that checks if their is a winner
    public void checkWinner() {

        // assign button text to string variable for comparisons
        String text1 = b1.getText().toString();
        String text2 = b2.getText().toString();
        String text3 = b3.getText().toString();
        String text4 = b4.getText().toString();
        String text5 = b5.getText().toString();
        String text6 = b6.getText().toString();
        String text7 = b7.getText().toString();
        String text8 = b8.getText().toString();
        String text9 = b9.getText().toString();

        // checks if proper rows match to declare a winner
        if ((text1.equals("O") && text2.equals("O") && text3.equals("O"))
                ||  (text1.equals("X") && text2.equals("X") && text3.equals("X"))
                ||  (text4.equals("O") && text5.equals("O") && text6.equals("O"))
                ||  (text4.equals("X") && text5.equals("X") && text6.equals("X"))
                ||  (text7.equals("O") && text8.equals("O") && text9.equals("O"))
                ||  (text7.equals("X") && text8.equals("X") && text9.equals("X"))
                ||  (text1.equals("O") && text4.equals("O") && text7.equals("O"))
                ||  (text1.equals("X") && text4.equals("X") && text7.equals("X"))
                ||  (text2.equals("O") && text5.equals("O") && text8.equals("O"))
                ||  (text2.equals("X") && text5.equals("X") && text8.equals("X"))
                ||  (text3.equals("O") && text6.equals("O") && text9.equals("O"))
                ||  (text3.equals("X") && text6.equals("X") && text9.equals("X"))
                ||  (text1.equals("O") && text5.equals("O") && text9.equals("O"))
                ||  (text1.equals("X") && text5.equals("X") && text9.equals("X"))
                ||  (text7.equals("O") && text5.equals("O") && text3.equals("O"))
                ||  (text7.equals("X") && text5.equals("X") && text3.equals("X"))) {

            // flags set to true and music plays if conditions are true
            winner = true;
            gameover = true;
            mp6.start();

            // displays win message based on the current player
            if (selection == 0)
                tv.setText("Player 1 WINS!");
            else if (selection == 1 && choice.equals("p2"))
                tv.setText("PLAYER 2 WINS!");
            else if (selection == 1 && choice.equals("cpu"))
                tv.setText("UNSEEN ANDROID WINS!");
        }
        // checks if current board status is equal to draw logic
        else if ((text1.equals("O") || text1.equals("X")) && (text2.equals("O") || text2.equals("X")) && (text3.equals("O") || text3.equals("X"))
                && (text4.equals("O") || text4.equals("X")) && (text5.equals("O") || text5.equals("X")) && (text6.equals("O") || text6.equals("X"))
                && (text7.equals("O") || text7.equals("X")) && (text8.equals("O") || text8.equals("X")) && (text9.equals("O") || text9.equals("X"))
                && (text1.equals("O") || text1.equals("X")) && (text4.equals("O") || text4.equals("X")) && (text7.equals("O") || text7.equals("X"))
                && (text2.equals("O") || text2.equals("X")) && (text5.equals("O") || text5.equals("X")) && (text8.equals("O") || text8.equals("X"))
                && (text3.equals("O") || text3.equals("X")) && (text6.equals("O") || text6.equals("X")) && (text9.equals("O") || text9.equals("X"))) {

            // sets flags to true, text to draw, and starts draw music
            winner = true;
            gameover = true;
            tv.setText("ITS A DRAW!");
            mp7.start();
        }
    }
    // functiont to switch players
    public void switchPlayer(int s) {

        proceed = false;
        // handle object to handle display and cpu action delay
        Handler handler = new Handler();

        // if player is currently player 1 switches to player 2 or executes cpu actions
        if (s == 0) {

                if (choice.equals("p2")) {
                    selection = 1;
                    tv.setText("PLAYER 2: CHOOSE TACTFULLY");
                }
                else if (choice.equals("cpu")) {

                    tv.setText("UNSEEN ANDROID 24 IS SELECTING");

                    // delays android logic, and checking winner
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            androidMove();
                            selection = 1;
                            checkWinner();
                        }
                    }, 1500);
                    // switches to player 1
                    if (gameover == false) {
                        selection = 0;
                    }
                }
        }
        // if current player is player 2 switches to player 1
        else if (s == 1) {
            selection = 0;
            tv.setText("PLAYER 1: CHOOSE WISELY");
        }
    }

    // function for opponent logic
    public void androidMove() {
        // assigns button text to string variable for text comparison
        String text1 = b1.getText().toString();
        String text2 = b2.getText().toString();
        String text3 = b3.getText().toString();
        String text4 = b4.getText().toString();
        String text5 = b5.getText().toString();
        String text6 = b6.getText().toString();
        String text7 = b7.getText().toString();
        String text8 = b8.getText().toString();
        String text9 = b9.getText().toString();


        // checks rows and columns for android to win
        if (text1.equals("O") && text2.equals("O") && !text3.equals("X") && !text3.equals("O")) {
            b3.setText("O");
            mp8.start();
        }
        else if (text2.equals("O") && text3.equals("O") && !text1.equals("X") && !text1.equals("O")) {
            b1.setText("O");
            mp8.start();
        }
        else if (text1.equals("O") && text3.equals("O") && !text2.equals("X") && !text2.equals("O")) {
            b2.setText("O");
            mp8.start();
        }
        else if (text1.equals("0") && text4.equals("0") && !text7.equals("X") && !text7.equals("O")) {
            b7.setText("O");
            mp8.start();
        }
        else if (text1.equals("0") && text7.equals("0") && !text4.equals("X") && !text4.equals("O")) {
            b4.setText("O");
            mp8.start();
        }
        else if (text4.equals("O") && text7.equals("O") && !text1.equals("X") && !text1.equals("O")) {
            b1.setText("O");
            mp8.start();
        }
        else if (text2.equals("O") && text5.equals("O") && !text8.equals("X") && !text8.equals("O")) {
            b8.setText("O");
            mp8.start();
        }
        else if (text2.equals("O") && text8.equals("O") && !text5.equals("X") && !text5.equals("O")) {
            b5.setText("O");
            mp8.start();
        }
        else if (text5.equals("O") && text8.equals("O") && !text2.equals("X") && !text2.equals("O")) {
            b2.setText("O");
            mp8.start();
        }
        else if (text3.equals("O") && text6.equals("O") && !text9.equals("X") && !text9.equals("O")) {
            b9.setText("O");
            mp8.start();
        }
        else if (text3.equals("O") && text9.equals("O") && !text6.equals("X") && !text6.equals("O")) {
            b6.setText("O");
            mp8.start();
        }
        else if (text9.equals("O") && text6.equals("O") && !text3.equals("X") && !text3.equals("O")) {
            b3.setText("O");
            mp8.start();
        }
        else if (text4.equals("O") && text5.equals("O") && !text6.equals("X") && !text6.equals("O")) {
            b6.setText("O");
            mp8.start();
        }
        else if (text4.equals("O") && text6.equals("O") && !text5.equals("X") && !text5.equals("O")) {
            b5.setText("O");
            mp8.start();
        }
        else if (text5.equals("O") && text6.equals("O") && !text4.equals("X") && !text4.equals("O")) {
            b4.setText("O");
            mp8.start();
        }
        else if (text7.equals("O") && text8.equals("O") && !text9.equals("X") && !text9.equals("O")) {
            b9.setText("O");
            mp8.start();
        }
        else if (text7.equals("O") && text9.equals("O") && !text8.equals("X") && !text8.equals("O")) {
            b8.setText("O");
            mp8.start();
        }
        else if (text9.equals("O") && text8.equals("O") && !text7.equals("X") && !text7.equals("O")) {
            b7.setText("O");
            mp8.start();
        }
        else if (text1.equals("O") && text5.equals("O") && !text9.equals("X") && !text9.equals("O")) {
            b9.setText("O");
            mp8.start();
        }
        else if (text1.equals("O") && text9.equals("O") && !text5.equals("X") && !text5.equals("O")) {
            b5.setText("O");
            mp8.start();
        }
        else if (text9.equals("O") && text5.equals("O") && !text1.equals("X") && !text1.equals("O")) {
            b1.setText("O");
            mp8.start();
        }
        else if (text3.equals("O") && text5.equals("O") && !text7.equals("X") && !text7.equals("O")) {
            b7.setText("O");
            mp8.start();

        }
        else if (text3.equals("O") && text7.equals("O") && !text5.equals("X") && !text5.equals("O")) {
            b5.setText("O");
            mp8.start();
        }
        else if (text7.equals("O") && text5.equals("O") && !text3.equals("X") && !text3.equals("O")) {
            b3.setText("O");
            mp8.start();
        }
        // checks rows and columns to properly block opponent
        else if (text1.equals("X") && text2.equals("X") && !text3.equals("X") && !text3.equals("O")) {
            b3.setText("O");
            mp8.start();
        }
        else if (text2.equals("X") && text3.equals("X") && !text1.equals("X") && !text1.equals("O")) {
                b1.setText("O");
            mp8.start();
        }
        else if (text1.equals("X") && text3.equals("X") && !text2.equals("X") && !text2.equals("O")) {
                b2.setText("O");
            mp8.start();
        }
        else if (text1.equals("X") && text4.equals("X") && !text7.equals("X") && !text7.equals("O")) {
                b7.setText("O");
            mp8.start();
        }
        else if (text1.equals("X") && text7.equals("X") && !text4.equals("X") && !text4.equals("O")) {
                b4.setText("O");
            mp8.start();
        }
        else if (text4.equals("X") && text7.equals("X") && !text1.equals("X") && !text1.equals("O")) {
                b1.setText("O");
            mp8.start();
        }
        else if (text2.equals("X") && text5.equals("X") && !text8.equals("X") && !text8.equals("O")) {
                b8.setText("O");
            mp8.start();
        }
        else if (text2.equals("X") && text8.equals("X") && !text5.equals("X") && !text5.equals("O")) {
                b5.setText("O");
            mp8.start();
        }
        else if (text5.equals("X") && text8.equals("X") && !text2.equals("X") && !text2.equals("O")) {
                b2.setText("O");
            mp8.start();
        }
        else if (text3.equals("X") && text6.equals("X") && !text9.equals("X") && !text9.equals("O")) {
                b9.setText("O");
            mp8.start();
        }
        else if (text3.equals("X") && text9.equals("X") && !text6.equals("X") && !text6.equals("O")) {
                b6.setText("O");
            mp8.start();
        }
        else if (text9.equals("X") && text6.equals("X") && !text3.equals("X") && !text3.equals("O")) {
                b3.setText("O");
            mp8.start();
        }
        else if (text4.equals("X") && text5.equals("X") && !text6.equals("X") && !text6.equals("O")) {
                b6.setText("O");
            mp8.start();
        }
        else if (text4.equals("X") && text6.equals("X") && !text5.equals("X") && !text5.equals("O")) {
                b5.setText("O");
            mp8.start();
        }
        else if (text5.equals("X") && text6.equals("X") && !text4.equals("X") && !text4.equals("O")) {
                b4.setText("O");
            mp8.start();
        }
        else if (text7.equals("X") && text8.equals("X") && !text9.equals("X") && !text9.equals("O")) {
                b9.setText("O");
            mp8.start();
        }
        else if (text7.equals("X") && text9.equals("X") && !text8.equals("X") && !text8.equals("O")) {
                b8.setText("O");
            mp8.start();
        }
        else if (text9.equals("X") && text8.equals("X") && !text7.equals("X") && !text7.equals("O")) {
                b7.setText("O");
            mp8.start();
        }
        else if (text1.equals("X") && text5.equals("X") && !text9.equals("X") && !text9.equals("O")) {
                b9.setText("O");
            mp8.start();
        }
        else if (text1.equals("X") && text9.equals("X") && !text5.equals("X") && !text5.equals("O")) {
                b5.setText("O");
            mp8.start();
        }
        else if (text9.equals("X") && text5.equals("X") && !text1.equals("X") && !text1.equals("O")) {
                b1.setText("O");
            mp8.start();
        }
        else if (text3.equals("X") && text5.equals("X") && !text7.equals("X") && !text7.equals("O")) {
                b7.setText("O");
            mp8.start();
        }
        else if (text3.equals("X") && text7.equals("X") && !text5.equals("X") && !text5.equals("O")) { ;
                b5.setText("O");
            mp8.start();
        }
        else if (text7.equals("X") && text5.equals("X") && !text3.equals("X") && !text3.equals("O")) {
                b3.setText("O");
            mp8.start();
        }
        else {

            // integer array list to auto select an empty box
            List<Integer> list = new ArrayList<>();

            // if statements to check if a box is empty, adds to int array list
             if (text1.equals(""))
                 list.add(1);

             if (text2.equals(""))
                 list.add(2);

             if (text3.equals(""))
                 list.add(3);

             if (text4.equals(""))
                 list.add(4);

            if (text5.equals(""))
                list.add(5);

            if (text6.equals(""))
                list.add(6);

            if (text7.equals(""))
                list.add(7);

            if (text8.equals(""))
                list.add(8);

            if (text9.equals(""))
                list.add(9);

            // randonly selects an item from int array list
            int randSquare = list.get(rand.nextInt(list.size()));

            // clears list
            list.clear();

            // based on item chosen, places android move and player sound.
            switch (randSquare) {
                case 1: {
                    b1.setText("O");
                    mp8.start();
                    break;
                }
                case 2: {
                    b2.setText("O");
                    mp8.start();
                    break;
                }
                case 3: {
                    b3.setText("O");
                    mp8.start();
                    break;
                }
                case 4: {
                    b4.setText("O");
                    mp8.start();
                    break;
                }
                case 5: {
                    b5.setText("O");
                    mp8.start();
                    break;
                }
                case 6: {
                    b6.setText("O");
                    mp8.start();
                    break;
                }
                case 7: {
                    b7.setText("O");
                    mp8.start();
                    break;
                }
                case 8: {
                    b8.setText("O");
                    mp8.start();
                    break;
                }
                case 9: {
                    b9.setText("O");
                    mp8.start();
                    break;
                }
                default:
                    break;
            }
            // add code
        } // end of else
        // sets flag to true to proceed and resets player 1 text
        proceed = true;
        tv.setText("PLAYER 1: CHOOSE WISELY");
    } //end of android function

    // function to check if box is empty for player 1 and player 2 moves.
    public void checkBox(Button b) {
        String text = b.getText().toString();
        if ((!text.equals("X") && !text.equals("O")) && selection == 0) {
            mp3.start();
            b.setText("X");
            proceed = true;
        }
        else if ((!text.equals("X") && !text.equals("O")) && selection == 1 && choice.equals("p2")) {
            mp4.start();
            b.setText("O");
            proceed = true;
        }
    }
}
