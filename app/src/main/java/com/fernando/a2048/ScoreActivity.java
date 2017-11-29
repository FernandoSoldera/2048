package com.fernando.a2048;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fernando.a2048.dao.PontuacaoDAO;
import com.fernando.a2048.model.Pontuacao;

import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private LinearLayout linearLayoutVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        linearLayoutVertical = (LinearLayout) findViewById(R.id.Table);

        List<Pontuacao> scores = new PontuacaoDAO(ScoreActivity.this).getTop5();

        for (int i = 0; i < scores.size(); i++) {
            LinearLayout linearLayoutHorizontal = new LinearLayout(ScoreActivity.this);
            linearLayoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
            linearLayoutHorizontal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            linearLayoutHorizontal.setPadding(250,0, 0, 0);

            TextView textViewPlace = new TextView(ScoreActivity.this);
            textViewPlace.setTextColor(Color.WHITE);
            textViewPlace.setTextSize(20);
            textViewPlace.setText(String.valueOf(i+1));
            textViewPlace.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
            linearLayoutHorizontal.addView(textViewPlace);

            TextView textViewScore = new TextView(ScoreActivity.this);
            textViewScore.setTextColor(Color.WHITE);
            textViewScore.setTextSize(20);
            textViewScore.setText(String.valueOf(scores.get(i).getPontuacao()));
            textViewScore.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            linearLayoutHorizontal.addView(textViewScore);

            linearLayoutVertical.addView(linearLayoutHorizontal);
        }
    }
}
