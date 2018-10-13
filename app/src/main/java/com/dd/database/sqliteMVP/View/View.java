package com.dd.database.sqliteMVP.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dd.database.sqliteMVP.Presenter.IPresenter;
import com.dd.database.sqliteMVP.Presenter.Presenter;
import com.dd.database.sqliteMVP.R;

import java.util.List;

public class View extends AppCompatActivity implements IView {

    private IPresenter iPresenter;
    private ListView mListview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        iPresenter = new Presenter(this);
        iPresenter.setDataToListview();
    }

    private void initView() {
        mListview1 = (ListView) findViewById(R.id.listview1);
    }

    @Override
    public void setDataToListview(List<String> stringList) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
        mListview1.setAdapter(arrayAdapter);
    }
}
