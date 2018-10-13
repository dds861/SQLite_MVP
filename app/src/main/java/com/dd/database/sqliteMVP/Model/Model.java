package com.dd.database.sqliteMVP.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    @Override
    public void setOpenHelper(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    @Override
    public SQLiteDatabase getDatabase() {
        return database;
    }

    @Override
    public void openDatabase() {
        database = openHelper.getWritableDatabase();
    }

    @Override
    public void closeDatabase() {
        if (database != null) {
            this.database.close();
        }
    }

    @Override
    public List<String> getList(SQLiteDatabase database) {
        List<String> list = new ArrayList<>();
        String sqlQueryText = "SELECT adam, til FROM makal";
        Cursor cursor = database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

}