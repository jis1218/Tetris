package com.example.tetris2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.Random;

/**
 * 테트리스 게임이 진행되는 영역
 */

public class Block {

    CallbackNice callbackNice;
    Context context;
    Setting setting;
    int cs, cs_preview, board_size;
    Paint paint;
    int blockColor[] = {Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.GRAY};
    int current_block[][];

    int initBlock[] = {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9};


    Board board;
    Background background;

    int x, y, z;

    int rannumForBoard;

    public Block(Context context, CallbackNice callbackNice) {
        this.context = context;
        setting = new Setting(context);
        cs = setting.cellsize;
        cs_preview = setting.cellsize_preview;
        board_size = setting.board_size;
        // 내려오는 블럭의 x, y 좌표
        x = 4;
        y = 0;
        // 회전 번호
        z = 0;
        if(board==null) {
            board = new Board(context);
        }
        this.callbackNice = callbackNice;
    }


    public void initBlock() {
        Random random = new Random();
        //rannumForBoard = random.nextInt(6);
        rannumForBoard = 2;
        current_block = blocks[rannumForBoard][0];
    }

    public Board blockStacked() {
        //board에 현재 블럭의 숫자와 배경의 숫자를 더해주는 과정
        for (int v = 0; v < 4; v++) {
            for (int h = 0; h < 4; h++) {
                if (v + y <= 16 && h + x >= 0 && h + x <= 11) {
                    board.board[v + y][h + x] += current_block[v][h];
                }
            }
        }
        //boolean checkif = false;
        for (int v = y + 3; v >= y; v--) {
            if (v >= 16) {
                continue;
            }
            boolean isFilled = true;
            for (int h = 1; h < 11; h++) {
                if (board.board[v][h] == 0) {
                    isFilled = false;
                    break;
                }
            }

            if (isFilled) {
                for (int ver = v; ver >= 1; ver--) {
                    board.board[ver] = board.board[ver - 1];
                    //checkif = true;
                }
                board.board[0] = initBlock;

            }

        }
//        if (checkif) {
//            for (int i = 0; i < 17; i++) {
//                for (int j = 0; j < 12; j++) {
//                    System.out.print(board.board[i][j]);
//                }
//                System.out.println("");
//            }
//        }
        System.out.println(x + "값  " + y + "값");


        return board;
    }

    public void rotateBlock() {

        int i = blocks[rannumForBoard].length;
        z++;
        current_block = blocks[rannumForBoard][z % i];
        if (checkCollision()) {
            z--;
            current_block = blocks[rannumForBoard][z % i];
        }

    }


    public Paint setPaint(int num) {
        paint = new Paint();
        paint.setColor(blockColor[num]);
        return paint;
    }

    public void drawBlockOnBoard(Canvas canvas) {

        for (int v = 0; v < 4; v++) {
            for (int h = 0; h < 4; h++) {
                if (current_block[v][h] > 0) {
                    canvas.drawRect((h + x) * cs, (v + y) * cs, (h + x + 1) * cs, (v + 1 + y) * cs, setPaint(rannumForBoard));
                }
            }
        }
    }

    public boolean checkCollision() {
        for (int v = 0; v < 4; v++) {
            for (int h = 0; h < 4; h++) {
                if (v + y <= 16 && h + x >= 0 && h + x <= 11) {
                    if (board.board[v + y][h + x] + current_block[v][h] > current_block[v][h] &&
                            board.board[v + y][h + x] + current_block[v][h] > board.board[v + y][h + x]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void moveRight() {

        x = x + 1;
        if (checkCollision()) {
            x = x - 1;
        }
    }

    public void moveLeft() {

        x = x - 1;
        if (checkCollision()) {
            x = x + 1;
        }
    }

    public void moveDown() {
        y = y + 1;
        if (checkCollision()) {
            y = y - 1;
            callbackNice.generateBlock(context);
        }
    }

    protected int blocks[][][][] =
            {
                    {
                            {
                                    {0, 1, 0, 0},
                                    {0, 1, 0, 0},
                                    {0, 1, 0, 0},
                                    {0, 1, 0, 0}
                            },
                            {
                                    {1, 1, 1, 1},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            }
                    },
                    {
                            {
                                    {0, 2, 0, 0},
                                    {2, 2, 2, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {0, 2, 0, 0},
                                    {0, 2, 2, 0},
                                    {0, 2, 0, 0},
                                    {0, 0, 0, 0},
                            },
                            {
                                    {0, 0, 0, 0},
                                    {2, 2, 2, 0},
                                    {0, 2, 0, 0},
                                    {0, 0, 0, 0},
                            },
                            {
                                    {0, 2, 0, 0},
                                    {2, 2, 0, 0},
                                    {0, 2, 0, 0},
                                    {0, 0, 0, 0},
                            }
                    },
                    {
                            {
                                    {0, 3, 3, 0},
                                    {0, 3, 3, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            }
                    },
                    {
                            {
                                    {0, 4, 0, 0},
                                    {4, 4, 0, 0},
                                    {4, 0, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {4, 4, 0, 0},
                                    {0, 4, 4, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0},
                            }
                    },
                    {
                            {
                                    {5, 0, 0, 0},
                                    {5, 5, 0, 0},
                                    {0, 5, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {0, 5, 5, 0},
                                    {5, 5, 0, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0},
                            }
                    },
                    {
                            {
                                    {0, 6, 0, 0},
                                    {0, 6, 6, 6},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {0, 6, 6, 0},
                                    {0, 6, 0, 0},
                                    {0, 6, 0, 0},
                                    {0, 0, 0, 0},
                            },
                            {
                                    {0, 6, 6, 6},
                                    {0, 0, 0, 6},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {0, 0, 6, 0},
                                    {0, 0, 6, 0},
                                    {0, 6, 6, 0},
                                    {0, 0, 0, 0},
                            }
                    },
                    {
                            {
                                    {0, 0, 7, 0},
                                    {7, 7, 7, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {0, 7, 0, 0},
                                    {0, 7, 0, 0},
                                    {0, 7, 7, 0},
                                    {0, 0, 0, 0},
                            },
                            {
                                    {7, 7, 7, 0},
                                    {7, 0, 0, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                            },
                            {
                                    {0, 7, 7, 0},
                                    {0, 0, 7, 0},
                                    {0, 0, 7, 0},
                                    {0, 0, 0, 0},
                            }
                    }
            };


}
