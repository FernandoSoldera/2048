package com.fernando.a2048.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ferna on 24/11/2017.
 */

public class SqlLite extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Pontuacao.db";

    public SqlLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create tb_funcionario table
        String sqlCreateTableTbFuncionario = "CREATE TABLE IF NOT EXISTS tb_pontuacao ("
        + "pk_pontuacao integer PRIMARY KEY AUTOINCREMENT,"
        + "pontuacao varchar(70) NOT NULL);";

        // create tb_funcionario table
        db.execSQL(sqlCreateTableTbFuncionario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older tb_funcionario table if existed
    //db.execSQL(&quot;DROP TABLE IF EXISTS tb_funcionario&quot;);

    // create fresh tb_funcionario table
    //this.onCreate(db);
    }
}
