package com.example.tetris2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.tetris2.database.DaoClass;
import com.example.tetris2.datalist.Score;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    ListView listView = null;
    ListAdapter adapter = null;
    ArrayList<Score> list = null;
    DaoClass daoClass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        init();

    }

    public void init(){
        daoClass = new DaoClass(this);
        list = daoClass.read();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new com.example.tetris2.datalist.ListAdapter(list, this);
        listView.setAdapter(adapter);
    }
}
