package com.robertolopes.jumpper.elements;

import android.graphics.Canvas;

import com.robertolopes.jumpper.graphic.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Canos {
    private final List<Cano> canos = new ArrayList<>();
    private final int QUANTIDADE_DE_CANOS = 400;
    private final int DISTANCIAS_ENTRE_CANOS = 200;
    private final Tela tela;

    public Canos(Tela tela) {
        this.tela = tela;
        int posicao = QUANTIDADE_DE_CANOS;
        for (int i = 0; i < 6; i++) {
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
        ListIterator<Cano> interator = canos.listIterator();
        while (interator.hasNext()) {
            Cano cano = interator.next();
            cano.move();
            if (cano.saiuDaTela()) {
                interator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIAS_ENTRE_CANOS);
                interator.add(outroCano);
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }
}
