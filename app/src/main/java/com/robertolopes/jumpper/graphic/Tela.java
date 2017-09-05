package com.robertolopes.jumpper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Tela {
    private final WindowManager systemService;
    private DisplayMetrics metrics;

    public Tela(Context context) {
        systemService = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = systemService.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public int getAltura(){
        return metrics.heightPixels;

    }
}
