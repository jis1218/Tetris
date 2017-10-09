package com.example.tetris2.datalist;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 정인섭 on 2017-10-08.
 */

@DatabaseTable(tableName = "Score")
public class Score {
    @DatabaseField
    public String date;
    @DatabaseField
    public int score;
}
