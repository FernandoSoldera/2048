package com.fernando.a2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    float initialX=0, initialY=0;
    private int[] valors = {16, 0, 16, 16, 32, 0, 0, 256, 512, 0, 512, 0, 0, 2, 0, 2}; //FIELD
    int[] newValors = {};

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
                    newValors = fieldMovement.moveLeftToRight(valors);
                    Log.e("error", newValors[0] + "" + newValors[1] + "" + newValors[2] + "" + newValors[3]);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }

                if (initialX > finalX) {
                    newValors = fieldMovement.moveRightToLeft(valors);
                    Log.e("error", newValors[0] + "" + newValors[1] + "" + newValors[2] + "" + newValors[3]);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }
            }
            else
            {
                if (initialY < finalY) {
                    newValors = fieldMovement.moveUpToDown(valors);
                    Log.e("error", newValors[0] + "" + newValors[1] + "" + newValors[2] + "" + newValors[3]);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
                }

                if (initialY > finalY) {
                    newValors = fieldMovement.moveDownToUp(valors);
                    Log.e("error", newValors[0] + "" + newValors[1] + "" + newValors[2] + "" + newValors[3]);
                    gridView.setAdapter(new TextViewAdapter(this, new String[16], gridView, newValors));
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
