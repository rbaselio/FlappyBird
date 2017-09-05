package com.robertolopes.jumpper.graphic;

import android.graphics.Paint;

/**
 * Created by roberto.lopes on 04/09/2017.
 */
public class Cores {
    public static Paint getCorDoPassaro() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getCorDoCano() {
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);
        return paint;
    }
}
