package br.edu.ifpb.padroes.atv3.desafio;

import java.util.ArrayList;
import java.util.List;

public class Combo implements CardapioComponent {
    private String nome;
    private String descricao;
    private List<CardapioComponent> itens;
    private double desconto; 
    
    public Combo(String nome, String descricao, double desconto) {
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(CardapioComponent item) {
        itens.add(item);
    }
    
    public void removerItem(CardapioComponent item) {
        itens.remove(item);
    }
    
    @Override
    public String getDescricao() {
        return nome + ": " + descricao;
    }
    
    @Override
    public double getPreco() {
        double precoTotal = 0;
        for (CardapioComponent item : itens) {
            precoTotal += item.getPreco();
        }
        return precoTotal * (1 - desconto / 100);
    }
    
    @Override
    public void exibir() {
        System.out.println("+ " + nome + ": " + descricao + " | R$ " + String.format("%.2f", getPreco()) + 
                          " (Desconto: " + desconto + "%)");
        
        for (CardapioComponent item : itens) {
            System.out.print("  ");
            item.exibir();
        }
    }
    
    public String getNome() {
        return nome;
    }
}