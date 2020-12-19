package com.codewithshashank.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0:red
    // 1:yellow
    int activePlayer=0;
    boolean gameon=true;
    TextView textView;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void tapped(View view)
    {
        ImageView imageView=(ImageView) view;
        if(gameState[Integer.parseInt(imageView.getTag().toString())]==2&&gameon) {
            imageView.setTranslationY(-2000);
            if (activePlayer == 0) {
                imageView.setImageResource(R.drawable.red);
                gameState[Integer.parseInt(imageView.getTag().toString())]=0;
                activePlayer = 1;
            } else {
                imageView.setImageResource(R.drawable.yellow);
                gameState[Integer.parseInt(imageView.getTag().toString())]=1;
                activePlayer = 0;
            }
            imageView.animate().translationYBy(2000).rotation(1800).setDuration(700);
            for(int[] winningPos:winningPositions)
            {
                if(gameState[winningPos[0]]==gameState[winningPos[1]]&&gameState[winningPos[1]]==gameState[winningPos[2]]
                &&gameState[winningPos[0]]!=2){
                    String winner;
                    if(activePlayer==1)winner="RED WON";
                    else winner="YELLOW WON";
                    textView.setText(winner);
                    gameon=false;

                }

            }int count=0;
            for(int i=0;i<9;i++)
                if(gameState[i]!=2)
                    count++;
                if(count==9){textView.setText("DRAW");
                gameon=false;}
        }

    }
    public void playAgain(View view)
    {
        ImageView imageView;
        imageView=findViewById(R.id.iv1);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv2);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv3);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv4);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv5);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv6);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv7);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv8);
        imageView.setImageDrawable(null);
        imageView=findViewById(R.id.iv9);
        imageView.setImageDrawable(null);
        for(int i=0;i<9;i++)
            gameState[i]=2;
        activePlayer=0;
        gameon=true;
        textView.setText("GAME ONg");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
    }
}
