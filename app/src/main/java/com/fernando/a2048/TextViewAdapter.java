package com.fernando.a2048;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ferna on 07/09/2017.
 */

public class TextViewAdapter extends BaseAdapter {
    private Context context;
    private final String[] textViewValues;
    private int[] valores;
    private View gridView;
    TextView textView;

    public TextViewAdapter(Context context, String[] textViewValues, View gridView, int[] valores) {
        this.context = context;
        this.textViewValues = textViewValues;
        this.gridView = gridView;
        this.valores= valores;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.activity_main, null);

            // set value into textview
            textView = new TextView(context);
            textView.setBackgroundColor(Color.WHITE);
            if(valores[position] > 0)
            {
                textView.setText(String.valueOf(valores[position]));
                choseColor(valores[position]);
            }
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(25);
            textView.setHeight((Resources.getSystem().getDisplayMetrics().widthPixels-250)/4);
        } else {
            gridView = (View) convertView;
        }

        return textView;
    }

    private void choseColor(int number)
    {
        switch (number){
            case 2:
                textView.setBackgroundResource(R.color.colorBlock2);
                break;
            case 4:
                textView.setBackgroundResource(R.color.colorBlock4);
                break;
            case 8:
                textView.setBackgroundResource(R.color.colorBlock8);
                break;
            case 16:
                textView.setBackgroundResource(R.color.colorBlock16);
                break;
            case 32:
                textView.setBackgroundResource(R.color.colorBlock32);
                break;
            case 64:
                textView.setBackgroundResource(R.color.colorBlock64);
                break;
            case 128:
                textView.setBackgroundResource(R.color.colorBlock128);
                break;
            case 256:
                textView.setBackgroundResource(R.color.colorBlock256);
                break;
            case 512:
                textView.setBackgroundResource(R.color.colorBlock512);
                break;
            case 1024:
                textView.setBackgroundResource(R.color.colorBlock1024);
                break;
            case 2048:
                textView.setBackgroundResource(R.color.colorBlock2048);
                break;
        }
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