package com.example.tetris2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by 정인섭 on 2017-09-29.
 */

public class Board{

    Context context;
    Paint paint = new Paint();
    Setting setting;

    int cs;

    public Board(Context context) {
        this.context = context;
        setting = new Setting(context);
        this.cs = setting.cellsize;
    }


    int color[] = {Color.WHITE, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.GRAY, 0, Color.BLACK};
    int board[][] = { //board[17][12]
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
    };

        public void drawBoard(Canvas canvas){
        for(int v=0; v<board.length; v++){
            for(int h=0; h<board[0].length; h++){
                paint.setColor(color[board[v][h]]);
                canvas.drawRect(h*cs, v*cs, (h+1)*cs, (v+1)*cs, paint);
            }
        }

    }

}
