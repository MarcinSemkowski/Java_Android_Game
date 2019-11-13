package com.example.game_connect_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 = yellow , 1= red

    int activePlayer =0;

    // 2 means un played;

    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5} ,{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){
        ImageView counter = (ImageView) view;


        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2) {

            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }


            counter.animate()
                    .translationYBy(1000f)
                    .setDuration(300);
         for(int[] winningPosition : winningPositions){

             if(gameState[winningPosition[0]] == gameState[winningPosition[1]]
                     && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                  && gameState[winningPosition[0]] != 2){

                 System.out.println(gameState[winningPosition[0]]);
                 //win!

                 TextView text = findViewById(R.id.winnerMessage);
                 if(gameState[winningPosition[0]] == 1){
                  text.setText("red Win !");
                 }else if(gameState[winningPosition[0]] == 0){
                     text.setText("Yellow Win !");
                 }


                 LinearLayout layout =   findViewById(R.id.playAgainLayout);
                 layout.setVisibility(View.VISIBLE);
             }
         }

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
