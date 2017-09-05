package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.graphic.Cores;
import com.robertolopes.jumpper.graphic.Tela;


public class Passaro {
    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private final Tela tela;
    private float altura;

    public Passaro(Tela tela) {
        this.altura = 100;
        this.tela = tela;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        boolean chegouNoChao = (altura + RAIO > tela.getAltura());
        if (!chegouNoChao) this.altura += 5;
    }

    public void pula() {

        if (altura > RAIO)
            this.altura -= 150;
        else this.altura = 0;
    }
}
