package com.example.tetris2;

import android.content.Context;

/**
 * Created by 정인섭 on 2017-09-29.
 */

public class Setting {

    // 게임판의 크기
    int width_background;

    // Board의 크기
    int board_size;
    // Board의 높이
    int board_height;
    // Board의 너비
    int board_width;

    // 게임판의 가로세로 개수
    int rows;

    // 프리뷰의 크기
    int width_preview;
    int height_preview;

    // 사각형 하나의 크기
    int cellsize;
    // PreviewBlock 사각형 하나의 크기
    int cellsize_preview;
    // PreviewBlock
    int rows_preview;

    public Setting(Context context) {
        width_background = context.getResources().getDisplayMetrics().widthPixels - 16;
        rows = 16;
        rows_preview = 6;
        board_size = width_background/rows*12;
        board_height = 17;
        board_width = 12;





        cellsize = width_background/(rows);
        cellsize_preview = (width_background - board_size)/rows_preview;


    }


    // 기본 크기
    float unit;
}
