package com.robertolopes.jumpper.elements;

import android.content.Context;
import android.graphics.Canvas;

import com.robertolopes.jumpper.graphic.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Canos {
    private final List<Cano> canos = new ArrayList<>();
    private final int QUANTIDADE_DE_CANOS = 400;
    private final int DISTANCIAS_ENTRE_CANOS = Cano.LARGURA_DO_CANO + (Tela.getLargura() / 3);
    private final Tela tela;
    private Pontuacao pontuacao;
    private Context context;

    public Canos(Tela tela, Pontuacao pontuacao, Context context) {
        this.tela = tela;
        this.pontuacao = pontuacao;
        this.context = context;
        int posicao = QUANTIDADE_DE_CANOS;
        for (int i = 0; i < 5; i++) {
            posicao += DISTANCIAS_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao, pontuacao, context);
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
                pontuacao.aumenta();
                interator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIAS_ENTRE_CANOS, pontuacao, context);
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

    public boolean temColisao(Passaro passaro) {
        for (Cano cano : canos) {
            if (cano.temColisaoHorizontal(passaro) &&
                    cano.temColisacaoVertical(passaro)) {
                return true;
            }
        }
        return false;
    }
}
