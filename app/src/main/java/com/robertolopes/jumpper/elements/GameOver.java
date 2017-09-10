package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.robertolopes.jumpper.graphic.Cores;
import com.robertolopes.jumpper.graphic.Tela;

/**
 * Created by roberto.lopes on 10/09/2017.
 */
public class GameOver {
    private static final Paint VERMELHO = Cores.getCorDoGameOver();
    private final Tela tela;

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas) {
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);

        canvas.drawText(gameOver, centroHorizontal, tela.getAltura() / 2, VERMELHO);
    }

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        VERMELHO.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        return Tela.getLargura() / 2 - (limiteDoTexto.right - limiteDoTexto.left) / 2;
    }
}
