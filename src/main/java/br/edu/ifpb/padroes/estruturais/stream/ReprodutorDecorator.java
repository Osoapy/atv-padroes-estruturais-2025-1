
package br.edu.ifpb.padroes.estruturais.stream;

public abstract class ReprodutorDecorator implements Reprodutor {
    protected final Reprodutor wrappee;

    protected ReprodutorDecorator(Reprodutor wrappee) { this.wrappee = wrappee; }

    @Override
    public void tocar(Musica musica) {
        wrappee.tocar(musica);
        aposTocar(musica);
    }

    protected abstract void aposTocar(Musica musica);
}
