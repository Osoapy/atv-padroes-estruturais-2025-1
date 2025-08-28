package br.edu.ifpb.padroes.atv3.desafio;

public class ItemCardapio implements CardapioComponent {
    private String nome;
    private String descricao;
    private double preco;
    
    public ItemCardapio(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    @Override
    public String getDescricao() {
        return nome + ": " + descricao;
    }
    
    @Override
    public double getPreco() {
        return preco;
    }
    
    @Override
    public void exibir() {
        System.out.println("- " + nome + ": " + descricao + " | R$ " + String.format("%.2f", preco));
    }
    
    public String getNome() {
        return nome;
    }
}