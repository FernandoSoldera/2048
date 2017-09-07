package com.fernando.a2048;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by ferna on 07/09/2017.
 */

public class TextViewAdapter extends BaseAdapter {
    private Context context;
    private final String[] textViewValues;
    private View gridView;
    TextView textView;

    public TextViewAdapter(Context context, String[] textViewValues, View gridView) {
        this.context = context;
        this.textViewValues = textViewValues;
        this.gridView = gridView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.activity_main, null);

            // set value into textview
             textView = new TextView(context);
            textView.setText("lallala");
        } else {
            gridView = (View) convertView;
        }

        return textView;
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