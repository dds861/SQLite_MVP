package com.dd.database.sqliteMVP.Presenter;

import com.dd.database.sqliteMVP.Model.IModel;
import com.dd.database.sqliteMVP.Model.Model;
import com.dd.database.sqliteMVP.View.IView;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements IPresenter {

    private IView iView;
    private IModel iModel;

    public Presenter(IView iView) {
        this.iView = iView;
        iModel = new Model(iView);
    }

    @Override
    public void setCategories() {

        List<String> list = iModel.getList();

        //deleting emtry cells
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            if (!s.isEmpty()) {
                stringList.add(s);
            }
        }

        //setting data to list in view
        iView.setCategoriesToList(stringList);

    }
}
