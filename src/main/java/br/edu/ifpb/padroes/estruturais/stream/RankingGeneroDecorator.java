
package br.edu.ifpb.padroes.estruturais.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RankingGeneroDecorator extends ReprodutorDecorator {
    private final Map<String, Integer> contagem = new HashMap<>();

    public RankingGeneroDecorator(Reprodutor wrappee) {
        super(wrappee);
    }

    @Override
    protected void aposTocar(Musica musica) {
        contagem.merge(musica.getGenero(), 1, Integer::sum);
    }

    public String generoMaisTocado() {
        return contagem.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse(null);
    }
}
