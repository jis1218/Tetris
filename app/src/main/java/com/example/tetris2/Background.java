package com.example.tetris2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by 정인섭 on 2017-10-02.
 */

interface CallbackNice {
    void generateBlock(Context context);
    void addGameOver();
}


public class Background extends View implements CallbackNice {

    Board board;
    Block block;
    PreviewBlock previewBlock;
    DownThread downThread;
    public static final int MOVE_DOWN = 123;
    Handler handler;
    AppCompatActivity activity;
    FragmentManager fragmentManager;

    public Background(Context context, AppCompatActivity activity) {
        super(context);
        this.activity = activity;
        board = new Board(context);
        block = new Block(context, this);
        previewBlock = new PreviewBlock(context, this);
        block.initBlock();
        setHandler();
        downThread = new DownThread(block, this, handler);
        downThread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        board.drawBoard(canvas);
        block.drawBlockOnBoard(canvas);
        previewBlock.drawBlockOnPreview(canvas);
    }

    @Override
    public void generateBlock(Context context) {
        board = block.blockStacked(downThread);
        block = new Block(context, this);

        //downThread = new DownThread(block, this, handler);
        block.board = board;
        block.current_block = previewBlock.preview_block;
        block.rannumForBoard = previewBlock.rannumForPreview;
        previewBlock = new PreviewBlock(context, this);
        //downThread.start();
    }

    public void setHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //super.handleMessage(msg);
                switch(msg.what){
                    case MOVE_DOWN :
                        block.moveDown();
                        invalidate();
                }
            }
        };
    }

    @Override
    public void addGameOver() {
        //activity.getSupportFragmentManager().beginTransaction().add(R.id.constraint, new GameOverFragment()).commit();
    }
}
