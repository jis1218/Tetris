package com.example.tetris2;

import android.os.Handler;

/**
 * Created by 정인섭 on 2017-10-03.
 */

public class DownThread extends Thread {

    Block block;
    CallbackNice callbackNice;
    Handler handler;

    DownThread(Block block, CallbackNice callbackNice, Handler handler){
        this.block = block;
        this.callbackNice = callbackNice;
        this.handler = handler;
    }

    @Override
    public void run() {
        //super.run();

        while(true){
            handler.sendEmptyMessage(Background.MOVE_DOWN);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
