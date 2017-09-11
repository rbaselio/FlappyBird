package com.robertolopes.jumpper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.R;
import com.robertolopes.jumpper.engine.Som;
import com.robertolopes.jumpper.graphic.Cores;
import com.robertolopes.jumpper.graphic.Tela;

public class Passaro {
    public static final int DESCE = 1;
    public static final int SOBE = 2;
    public static final float X = 100;
    public static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private final Tela tela;
    private final Bitmap passaro;
    private final Context context;
    private final Som som;
    private float altura;
    private Pontuacao pontos;

    public Passaro(Tela tela, Pontuacao pontos, Context context, Som som) {
        this.pontos = pontos;
        this.context = context;
        this.som = som;
        this.altura = 100;
        this.tela = tela;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.passaro);
        this.passaro = Bitmap.createScaledBitmap(bitmap, (int) RAIO * 2, (int) RAIO * 2, false);
    }

    public void desenhaNoCanvas(Canvas canvas) {
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    public void movimento(int direcao) {
        int aceleracao = (10 + pontos.getAceleracao());
        if (direcao == DESCE) {
            boolean chegouNoChao = (altura + RAIO > tela.getAltura());
            if (!chegouNoChao) this.altura += aceleracao;
        }
        if (direcao == SOBE) {
            som.toca(Som.PULO);
            if (altura > RAIO) this.altura -= aceleracao;
            else this.altura = RAIO;
        }
    }

    public float getAltura() {
        return this.altura;
    }
}
