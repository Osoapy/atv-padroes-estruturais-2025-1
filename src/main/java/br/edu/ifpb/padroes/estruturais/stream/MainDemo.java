
package br.edu.ifpb.padroes.estruturais.stream;

import java.util.List;

public class MainDemo {
    public static void main(String[] args) throws Exception {
        String abcdUrl = System.getenv().getOrDefault("ABCD_URL", "http://localhost:3000");
        String xptoUrl = System.getenv().getOrDefault("XPTO_URL", "http://localhost:4000");

        ServicoMusica abcd = new ServicoAbcd(abcdUrl);
        ServicoMusica xpto = new ServicoXptoAdapter(new ClientXpto(xptoUrl));

        ServicoMusica composto = new ServicoComposto(List.of(abcd, xpto));
        ServicoMusica servicoCacheado = new ServicoMusicaProxy(composto); // Proxy com cache

        // Reprodutor com decorators (use quando necessário)
        Reprodutor player = new TocadorBasico();
        var contador = new ContadorExecucoesDecorator(player);
        var rankArtista = new RankingArtistaDecorator(contador);
        var rankGenero = new RankingGeneroDecorator(rankArtista);

        MusicaStreamFacade facade = new MusicaStreamFacade(servicoCacheado, rankGenero);

        System.out.println("=== BUSCA POR TITULO: 'a' ===");
        var lista = facade.buscarPorTitulo("a");
        lista.stream().limit(5).forEach(System.out::println);

        if (!lista.isEmpty()) {
            System.out.println("=== TOCANDO PRIMEIRAS 3 ===");
            for (int i = 0; i < Math.min(3, lista.size()); i++) {
                facade.tocar(lista.get(i));
            }
        }

        System.out.println("Total execucoes: " + contador.getTotalExecucoes());
        System.out.println("Artista mais tocado: " + rankArtista.artistaMaisTocado());
        System.out.println("Genero mais tocado: " + rankGenero.generoMaisTocado());
    }
}
