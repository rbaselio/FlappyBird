package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.graphic.Cores;
import com.robertolopes.jumpper.graphic.Tela;

public class Passaro {
    public static final int DESCE = 1;
    public static final int SOBE = 2;
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

    public void movimento(int direcao) {

        if (direcao == DESCE) {
            boolean chegouNoChao = (altura + RAIO > tela.getAltura());
            if (!chegouNoChao) this.altura += 10;
        }
        if (direcao == SOBE) {
            if (altura > RAIO) this.altura -= 10;
            else this.altura = RAIO;
        }
    }
}
