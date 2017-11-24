package com.fernando.a2048;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    float initialX=0, initialY=0;
    //private int[] valors = {0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0}; //FIELD
    private int[] valors = {2, 4, 8, 16, 16, 8, 4, 2, 2, 4, 8, 16, 16, 8, 4, 2}; //FIELD Loose
    //private int[] valors = {1024, 1024, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //FIELD Win
    int[] newValors = {};
    private TextView score;
    MediaPlayer mediaPlayerLose;
    static MediaPlayer mediaPlayerWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        score = (TextView) findViewById(R.id.tvScore);

        gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, valors));

        gridView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent motionEvent) {
                touchEvent(motionEvent);
                return true;
            }
        });
        calculatePoints();

        mediaPlayerLose = MediaPlayer.create(this, R.raw.losesound);
        mediaPlayerWin = MediaPlayer.create(this, R.raw.winsound);
    }

    /**
     * Method to calculate the direction of the movement
     * @param motionEvent event
     */
    public void touchEvent(MotionEvent motionEvent)
    {
        if(motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN)
        {
            initialX = motionEvent.getX();
            initialY = motionEvent.getY();
        }

        if(motionEvent.getActionMasked() == MotionEvent.ACTION_UP)
        {
            float finalX = motionEvent.getX();
            float finalY = motionEvent.getY();

            if(Math.pow(initialX - finalX, 2) > Math.pow(initialY - finalY, 2))
            {
                if (initialX < finalX) {
                    newValors = fieldMovement.moveLeftToRight(valors, 0);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }

                if (initialX > finalX) {
                    newValors = fieldMovement.moveRightToLeft(valors, 0);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }
            }
            else
            {
                if (initialY < finalY) {
                    newValors = fieldMovement.moveUpToDown(valors, 0);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }

                if (initialY > finalY) {
                    newValors = fieldMovement.moveDownToUp(valors, 0);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }
            }
            verifyMovements();
        }
    }

    /**
     * Touch event listener
     * @param motionEvent event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent)
    {
        touchEvent(motionEvent);
        return true;
    }

    public void calculatePoints(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            score.setText(String.valueOf(Points.getInstance().getTotalPoints()));
                        }
                    });

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public void verifyMovements(){
        int[] verifyValors = {};
        int gameOver = 0;

        verifyValors = fieldMovement.moveDownToUp(newValors, 1);
        if(verifyValors[0]==0){
            verifyValors = fieldMovement.moveUpToDown(newValors, 1);
            if(verifyValors[0]==0){
                verifyValors = fieldMovement.moveRightToLeft(newValors, 1);
                if(verifyValors[0]==0){
                    verifyValors = fieldMovement.moveLeftToRight(newValors, 1);
                    if(verifyValors[0]==0){
                        gameOver = 1;
                    }
                }
            }
        }

        if(gameOver==1){
            playLooseSound();
            vibrate();
            Toast.makeText(this.getApplicationContext(), "GAME OVER", Toast.LENGTH_LONG).show();
        }else{

        }
    }

    private void vibrate(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(300);
    }

    private void playLooseSound(){
        mediaPlayerLose.start();
    }

    public static void playWinSound(){
        mediaPlayerWin.start();
    }
}
