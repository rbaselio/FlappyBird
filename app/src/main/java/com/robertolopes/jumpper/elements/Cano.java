package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.graphic.Cores;
import com.robertolopes.jumpper.graphic.Tela;

public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private static final Paint VERDE = Cores.getCorDoCano();
    private int alturaDoCanoInferior;
    private int alturaDocanoSuperior;
    private int posicao;
    private Tela tela;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        alturaDocanoSuperior = TAMANHO_DO_CANO + valorAleatorio();
        this.posicao = posicao;
    }

    private int valorAleatorio() {
        return (int) (Math.random() * (tela.getAltura() / 2)) - 300;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        desenhaCanoInferior(canvas);
        desenhaCanoSuperior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDocanoSuperior, VERDE);
    }

    public void move() {
        this.posicao -= 5;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }
}
