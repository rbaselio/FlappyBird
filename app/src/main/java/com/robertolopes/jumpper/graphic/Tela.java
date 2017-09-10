package com.robertolopes.jumpper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Tela {
    private static DisplayMetrics metrics;
    public final Context context;
    private final WindowManager systemService;

    public Tela(Context context) {
        this.context = context;
        systemService = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = systemService.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public static int getLargura() {
        return metrics.widthPixels;
    }

    public int getAltura(){
        return metrics.heightPixels;
    }
}
