package com.robertolopes.jumpper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.robertolopes.jumpper.R;
import com.robertolopes.jumpper.graphic.Tela;

import static com.robertolopes.jumpper.elements.Passaro.RAIO;

public class Cano {
    public static final int LARGURA_DO_CANO = Tela.getLargura() / 7;
    private Bitmap canoInferior;
    private Bitmap canoSuperior;
    private int alturaDoCanoInferior;
    private int alturaDocanoSuperior;
    private Pontuacao pontos;
    private int posicao;
    private Tela tela;

    public Cano(Tela tela, int posicao, Pontuacao pontos, Context context) {
        this.tela = tela;
        this.pontos = pontos;
        this.posicao = posicao;
        alturaDoCanoInferior = (int) (Math.random() * tela.getAltura());
        alturaDocanoSuperior = (int) (alturaDoCanoInferior - (250 + Math.random() * 300));
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bitmap, LARGURA_DO_CANO, tela.getAltura(), false);
        this.canoSuperior = Bitmap.createScaledBitmap(bitmap, LARGURA_DO_CANO, alturaDocanoSuperior, false);
    }

    public void desenhaNoCanvas(Canvas canvas) {
        desenhaCanoInferior(canvas);
        desenhaCanoSuperior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void move() {
        this.posicao -= (5 + pontos.getAceleracao());
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO <= 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontal(Passaro passaro) {
        return this.posicao <= Passaro.X + RAIO;
    }

    public boolean temColisacaoVertical(Passaro passaro) {
        return passaro.getAltura() - RAIO <= this.alturaDocanoSuperior || passaro.getAltura() + RAIO >= this.alturaDoCanoInferior;
    }
}
