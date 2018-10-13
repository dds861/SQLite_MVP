package com.dd.database.sqliteMVP.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        iPresenter.setCategories();
        mListview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Toast.makeText(View.this, "Was clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mListview1 = (ListView) findViewById(R.id.listview1);
    }

    @Override
    public DatabaseOpenHelper getDatabaseOpenHelper() {
        return new DatabaseOpenHelper(getApplicationContext());
    }


    @Override
    public void setCategoriesToList(List<String> categoriesToList) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categoriesToList);
        mListview1.setAdapter(arrayAdapter);
    }
}
