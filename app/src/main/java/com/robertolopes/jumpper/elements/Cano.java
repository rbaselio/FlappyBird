package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.graphic.Cores;
import com.robertolopes.jumpper.graphic.Tela;

public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private static final Paint VERDE = Cores.getCorDoCano();
    private final int alturaDoCano;
    private int posicao;
    private Tela tela;
    private float larguraDoCano;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        alturaDoCano = tela.getAltura() - TAMANHO_DO_CANO;
        this.posicao = posicao;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCano, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }

    public void move() {
        this.posicao -= 5;
    }
}
