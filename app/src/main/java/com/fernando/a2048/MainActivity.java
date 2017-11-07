package com.fernando.a2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    float initialX=0, initialY=0;
    private int[] valors = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 0, 0, 0, 0, 0}; //FIELD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, valors));

        gridView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent motionEvent) {
                touchEvent(motionEvent);
                return true;
            }
        });
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
                    fieldMoviment.moveLeftToRight(valors);
                }

                if (initialX > finalX) {
                    fieldMoviment.moveRightToLeft(valors);
                }
            }
            else
            {
                if (initialY < finalY) {
                    fieldMoviment.moveUpToDown(valors);
                }

                if (initialY > finalY) {
                    fieldMoviment.moveDownToUp(valors);
                }
            }

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
}
