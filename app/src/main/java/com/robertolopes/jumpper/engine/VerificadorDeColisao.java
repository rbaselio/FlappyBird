package com.robertolopes.jumpper.engine;

import com.robertolopes.jumpper.elements.Canos;
import com.robertolopes.jumpper.elements.Passaro;

/**
 * Created by roberto.lopes on 10/09/2017.
 */
class VerificadorDeColisao {
    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao() {
    }

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisao(passaro);
    }
}
