package br.edu.ifpb.padroes.atv3.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<CardapioComponent> itens;
    
    public Cardapio() {
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(CardapioComponent item) {
        itens.add(item);
    }
    
    public void removerItem(CardapioComponent item) {
        itens.remove(item);
    }
    
    public void exibirCardapio() {
        System.out.println("========== CARDÁPIO ==========");
        for (CardapioComponent item : itens) {
            item.exibir();
            System.out.println();
        }
        System.out.println("==============================");
    }
    
    public CardapioComponent buscarItem(String nome) {
        for (CardapioComponent item : itens) {
            if (item instanceof ItemCardapio && ((ItemCardapio) item).getNome().equalsIgnoreCase(nome)) {
                return item;
            } else if (item instanceof Combo && ((Combo) item).getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }
}
