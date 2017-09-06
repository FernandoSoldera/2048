package com.fernando.a2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;

    static final String[] numbers = new String[] {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    private TextView[] tabuleiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);

        TextView textView = new TextView(this);
        textView.setText("ANA");
        tabuleiro = new TextView[]{
                textView
        };

        ArrayAdapter<TextView> adapter1 = new ArrayAdapter<TextView>(this, android.R.layout.simple_list_item_1, tabuleiro);

        gridView.setAdapter(adapter1);
    }
}
