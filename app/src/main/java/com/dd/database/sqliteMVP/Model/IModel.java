package com.dd.database.sqliteMVP.Model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public interface IModel {

    void setOpenHelper(SQLiteOpenHelper openHelper);

    SQLiteDatabase getDatabase();

    void openDatabase();

    void closeDatabase();

    List<String> getList(SQLiteDatabase database);
}
