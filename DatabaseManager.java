package com.example.nnelanut.snakeapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by nnelanut on 11/29/2017.
 */


public class DatabaseManager extends SQLiteOpenHelper {
    private final String scoreList = "SCORELIST";
    private final String name = "NAME";
    private final String score = "SCORE";
    private final int version = 1;

    DatabaseManager (Context context) {
            super(context, "SCORELIST", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlCreate = "CREATE TABLE " + scoreList + "(";
        sqlCreate += name + " varchar(255), ";
        sqlCreate += score + "integer);";

        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(UserScore userScore) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sqlInsert = "INSERT INTO " + scoreList + " VALUES('";
        sqlInsert += userScore.getName() + "'," + userScore.getScore() + ");";

        db.execSQL(sqlInsert);
    }

    public ArrayList<UserScore> selectAll() {

        String sqlSelect = "SELECT * FROM " + scoreList + " ORDER BY '" + score + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( sqlSelect, null );

        ArrayList<UserScore> scores = new ArrayList<UserScore>( );
        while(cursor.moveToNext()) {
            UserScore newScore = new UserScore(cursor.getString(0), cursor.getInt(1));
            scores.add(newScore);
        }
        db.close();
        return scores;
    }
}
