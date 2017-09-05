package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;

import com.robertolopes.jumpper.graphic.Tela;

import java.util.ArrayList;
import java.util.List;

public class Canos {
    private final List<Cano> canos = new ArrayList<>();
    private final int QUANTIDADE_DE_CANOS = 400;
    private final int DISTANCIAS_ENTRE_CANOS = 200;

    public Canos(Tela tela) {
        int posicao = QUANTIDADE_DE_CANOS;
        for (int i = 0; i < 5; i++) {
            posicao += DISTANCIAS_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao);
            canos.add(cano);
        }
    }

    public void desenhaNoCanvas(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNoCanvas(canvas);
        }
    }

    public void move() {
        for (Cano cano : canos) {
            cano.move();
        }
    }
}
