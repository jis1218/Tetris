package com.example.tetris2;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    Background background;

    Button btnUp, btnDown, btnRight, btnLeft, finish;
    Button test;
    View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        addBackgroundToContainer();
        buttonClick();
        setListener();


        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    public void initiate() {
        container = (FrameLayout) findViewById(R.id.container);
        background = new Background(this, this);
        btnDown = (Button) findViewById(R.id.btnDown);
        btnUp = (Button) findViewById(R.id.btnUp);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        finish = (Button) findViewById(R.id.finish);
    }

    public void addBackgroundToContainer() {
        container.addView(background);
    }

    public void setListener() {
        btnUp.setOnClickListener(onClickListener);
        btnDown.setOnClickListener(onClickListener);
        btnRight.setOnClickListener(onClickListener);
        btnLeft.setOnClickListener(onClickListener);
        finish.setOnClickListener(onClickListener);
    }

    public void buttonClick() {

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnUp:
                        background.block.rotateBlock();
                        background.invalidate();
                        break;
                    case R.id.btnDown:
                        background.block.moveDown();
                        background.invalidate();
                        break;
                    case R.id.btnRight:
                        background.block.moveRight();
                        background.invalidate();
                        break;
                    case R.id.btnLeft:
                        background.block.moveLeft();
                        background.invalidate();
                        break;
                    case R.id.finish:
                        finish();
                        break;
                }
            }
        };
    }

}
