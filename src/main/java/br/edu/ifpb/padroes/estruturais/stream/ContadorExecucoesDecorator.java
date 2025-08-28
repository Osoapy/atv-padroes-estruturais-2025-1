
package br.edu.ifpb.padroes.estruturais.stream;

import java.util.concurrent.atomic.AtomicInteger;

public class ContadorExecucoesDecorator extends ReprodutorDecorator {
    private final AtomicInteger contador = new AtomicInteger(0);

    public ContadorExecucoesDecorator(Reprodutor wrappee) {
        super(wrappee);
    }

    @Override
    protected void aposTocar(Musica musica) {
        contador.incrementAndGet();
    }

    public int getTotalExecucoes() {
        return contador.get();
    }
}
