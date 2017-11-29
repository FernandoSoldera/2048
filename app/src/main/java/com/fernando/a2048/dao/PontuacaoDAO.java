package com.fernando.a2048.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fernando.a2048.model.Pontuacao;
import com.fernando.a2048.util.SqlLite;

import java.util.ArrayList;

/**
 * Created by ferna on 24/11/2017.
 */

public class PontuacaoDAO {

    private SQLiteDatabase db = null;
    private SqlLite sqlLite = null;

    public PontuacaoDAO(Context context) {
        sqlLite = new SqlLite(context);
    }

    public long insert(Pontuacao pontuacao) throws SQLException {
        this.db = sqlLite.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("pontuacao", pontuacao.getPontuacao());

        long number = db.insert("tb_pontuacao", null, cv);
        db.close();
        return number;
    }

    public ArrayList<Pontuacao> getTop5() {
        ArrayList<Pontuacao> pointsList = new ArrayList<Pontuacao>();

        String query = "SELECT * FROM tb_pontuacao ORDER BY pontuacao DESC LIMIT 5";
        this.db = sqlLite.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Pontuacao pontuacao = new Pontuacao();
                pontuacao.setPk_Pontuacao(Integer.parseInt(cursor.getString(0)));
                pontuacao.setPontuacao(cursor.getString(1));
                pointsList.add(pontuacao);
            } while (cursor.moveToNext());
        }

        db.close();
        return pointsList;
    }

    public String getBestScore(){
        String query = "SELECT MAX(pontuacao) FROM tb_pontuacao";

        this.db = sqlLite.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            return cursor.getString(0);
        }

        return "";
    }
}
