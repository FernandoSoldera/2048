package com.fernando.a2048;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ferna on 07/09/2017.
 */

public class TextViewAdapter extends BaseAdapter {
    private Context context;
    private final String[] textViewValues;
    private int[] valors;
    private View gridView;
    TextView textView;

    public TextViewAdapter(Context context, String[] textViewValues, View gridView, int[] valores) {
        this.context = context;
        this.textViewValues = textViewValues;
        this.gridView = gridView;
        this.valors= valores;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridView = inflater.inflate(R.layout.activity_main, null);

            textView = new TextView(context);
            GradientDrawable gd = new GradientDrawable();
            gd.setCornerRadius(10);
            gd.setColor(Color.LTGRAY);

            if(valors[position] > 0)
            {
                textView.setText(String.valueOf(valors[position]));
                gd.setColor(Color.parseColor(choseColor(valors[position])));
            }

            textView.setBackground(gd);

            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(25);
            textView.setHeight((Resources.getSystem().getDisplayMetrics().widthPixels-250)/4);
        } else {
            gridView = (View) convertView;
        }

        return textView;
    }

    /**
     * Method to chooses the color according to the number
     * @param number block valor
     * @return color
     */
    private String choseColor(int number)
    {
        switch (number){
            case 2:
                return "#eee4da";
            case 4:
                return "#ede0c8";
            case 8:
                return "#f2b179";
            case 16:
                return "#f59563";
            case 32:
                return "#f67c5f";
            case 64:
                return "#f65e3b";
            case 128:
                return "#edcf72";
            case 256:
                return "#edcc61";
            case 512:
                return "#edc850";
            case 1024:
                return "#edc53f";
            case 2048:
                new MainActivity().playWinSound();
                Toast.makeText(context, "YOU WIN", Toast.LENGTH_LONG).show();
                return "#FFEDC22E";
        }
        return null;
    }

    @Override
    public int getCount() {
        return textViewValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}