package br.edu.ifpb.padroes.atv3.desafio;

// Interface comum para todos os componentes do cardápio
public interface CardapioComponent {
    String getDescricao();
    double getPreco();
    void exibir();
}