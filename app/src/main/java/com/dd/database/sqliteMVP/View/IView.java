package com.dd.database.sqliteMVP.View;

import java.util.List;

public interface IView {

    DatabaseOpenHelper getDatabaseOpenHelper();

    void setCategoriesToList(List<String> categoriesToList);

}
