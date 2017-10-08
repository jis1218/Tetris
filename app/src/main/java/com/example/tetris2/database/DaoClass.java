package com.example.tetris2.database;

import android.content.Context;

import com.example.tetris2.datalist.Score;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-08.
 */

public class DaoClass {
    private DBHelper helper = null;
    private Dao<Score, Integer> dao = null;

    public DaoClass(Context context) {
        helper = new DBHelper(context);
        try {
            dao = helper.getDao(Score.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Score score){
        try {
            dao.create(score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Score> read(){
        ArrayList<Score> list = null;
        try {
            list = (ArrayList) dao.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
