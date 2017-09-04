package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.grafic.Cores;

/**
 * Created by roberto.lopes on 04/09/2017.
 */
public class Passaro {
    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private float altura;

    public Passaro(float altura) {
        this.altura = altura;
    }

    public void desenhaNoCanvas(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        this.altura += 5;
    }
}
