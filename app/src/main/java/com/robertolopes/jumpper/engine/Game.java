package com.robertolopes.jumpper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.robertolopes.jumpper.R;
import com.robertolopes.jumpper.elements.Canos;
import com.robertolopes.jumpper.elements.GameOver;
import com.robertolopes.jumpper.elements.Passaro;
import com.robertolopes.jumpper.elements.Pontuacao;
import com.robertolopes.jumpper.graphic.Tela;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private Context context;
    private boolean isRunning;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap fundo;
    private Tela tela;
    private Canos canos;
    private int movimento = Passaro.DESCE;
    private Pontuacao pontuacao;

    public Game(Context context) {
        super(context);
        tela = new Tela(context);
        this.context = context;
        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        pontuacao = new Pontuacao();
        passaro = new Passaro(tela, pontuacao, context);
        canos = new Canos(tela, pontuacao, context);
        Bitmap bt = BitmapFactory.decodeResource(getResources(), R.mipmap.background);
        tela = new Tela(this.getContext());
        fundo = Bitmap.createScaledBitmap(bt, bt.getWidth(), tela.getAltura(), false);
        inicia();
    }

    @Override
    public void run() {
        while (isRunning) {
            if (holder.getSurface().isValid()) {

                Canvas canvas = holder.lockCanvas();
                canvas.drawBitmap(fundo, 0, 0, null);

                passaro.desenhaNoCanvas(canvas);
                passaro.movimento(movimento);

                canos.desenhaNoCanvas(canvas);
                canos.move();

                pontuacao.desenhaNoCanvas(canvas);

                if (new VerificadorDeColisao(passaro, canos).temColisao()) {
                    new GameOver(tela).desenhaNo(canvas);
                    pausa();
                }

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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                movimento = Passaro.SOBE;
                return true;
            case MotionEvent.ACTION_UP:
                movimento = Passaro.DESCE;
                return true;
        }
        return false;
    }
}
