package com.example.tetris2;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    Background background;

    Button btnUp, btnDown, btnRight, btnLeft;
    TextView highScore, score;

    View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        addBackgroundToContainer();
        buttonClick();
        setListener();
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
        highScore = (TextView) findViewById(R.id.high_score);
        score = (TextView) findViewById(R.id.score);
    }

    public void addBackgroundToContainer() {
        container.addView(background);
    }

    public void setListener() {
        btnUp.setOnClickListener(onClickListener);
        btnDown.setOnClickListener(onClickListener);
        btnRight.setOnClickListener(onClickListener);
        btnLeft.setOnClickListener(onClickListener);
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
