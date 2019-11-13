package com.example.game_connect_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
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

    public void playAgain(View view){
        LinearLayout layout =   findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;
        for(int i =0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ImageView image0 = findViewById(R.id.image0);
        image0.setImageResource(0);

        ImageView image1 = findViewById(R.id.image1);
        image1.setImageResource(0);

        ImageView image2 = findViewById(R.id.image2);
        image2.setImageResource(0);

        ImageView image3 = findViewById(R.id.image3);
        image3.setImageResource(0);

        ImageView image4 = findViewById(R.id.image4);
        image4.setImageResource(0);

        ImageView image5 = findViewById(R.id.image5);
        image5.setImageResource(0);

        ImageView image6 = findViewById(R.id.image6);
        image6.setImageResource(0);

        ImageView image7 = findViewById(R.id.image7);
        image7.setImageResource(0);

        ImageView image8 = findViewById(R.id.image8);
        image8.setImageResource(0);

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
