package com.example.tetris2;

import android.content.Context;
import android.graphics.Canvas;

import java.util.Random;

/**
 * Created by 정인섭 on 2017-10-03.
 */

public class PreviewBlock extends Block {

    int preview_block[][];
    int rannumForPreview;

    public PreviewBlock(Context context, CallbackNice callbackNice) {
        super(context, callbackNice);
        Random random = new Random();
        //rannumForPreview = random.nextInt(6);
        rannumForPreview = 2;
        preview_block = blocks[rannumForPreview][0];

    }

    public void drawBlockOnPreview(Canvas canvas) {

        for (int v = 0; v < 4; v++) {
            for (int h = 0; h < 4; h++) {
                if (preview_block[v][h] > 0) {
                    canvas.drawRect((h + 1) * cs_preview + board_size, (v) * cs_preview,
                            (h + 2) * cs_preview + board_size, (v + 1) * cs_preview, setPaint(rannumForPreview));
                }
            }
        }
    }


}
