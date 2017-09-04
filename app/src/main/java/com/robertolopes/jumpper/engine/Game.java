package com.robertolopes.jumpper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.robertolopes.jumpper.elements.Passaro;

/**
 * Created by roberto.lopes on 04/09/2017.
 */
public class Game extends SurfaceView implements Runnable{
    private boolean isRunning;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;

    public Game(Context context) {
        super(context);
        inicializaElementos();
    }

    private void inicializaElementos() {
        passaro = new Passaro(100);
    }

    @Override
    public void run() {
        while (isRunning){

            if (holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();
                passaro.desenhaNoCanvas(canvas);
                passaro.cai();

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }
}
