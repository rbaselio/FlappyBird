package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.robertolopes.jumpper.graphic.Cores;

public class Pontuacao {
    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos;

    public int getAceleracao() {
        return pontos / 10;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);
    }

    public void aumenta() {
        pontos++;
    }
}
