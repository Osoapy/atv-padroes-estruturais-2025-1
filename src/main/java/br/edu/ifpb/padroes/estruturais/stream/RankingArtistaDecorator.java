
package br.edu.ifpb.padroes.estruturais.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RankingArtistaDecorator extends ReprodutorDecorator {
    private final Map<String, Integer> contagem = new HashMap<>();

    public RankingArtistaDecorator(Reprodutor wrappee) {
        super(wrappee);
    }

    @Override
    protected void aposTocar(Musica musica) {
        contagem.merge(musica.getArtista(), 1, Integer::sum);
    }

    public String artistaMaisTocado() {
        return contagem.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse(null);
    }
}
