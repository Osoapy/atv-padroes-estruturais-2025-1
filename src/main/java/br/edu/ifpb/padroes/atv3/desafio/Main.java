package br.edu.ifpb.padroes.atv3.desafio;

public class Main {
    public static void main(String[] args) {
        // Criando o cardápio
        Cardapio cardapio = new Cardapio();
        
        // Criando itens individuais
        ItemCardapio pizza = new ItemCardapio("Pizza Margherita", 
            "Pizza com molho de tomate, mussarela e manjericão", 45.90);
        
        ItemCardapio refrigerante = new ItemCardapio("Refrigerante", 
            "Lata 350ml - Escolha o sabor", 6.50);
        
        ItemCardapio sobremesa = new ItemCardapio("Pudim", 
            "Pudim de leite condensado com calda de caramelo", 12.90);
        
        ItemCardapio hamburguer = new ItemCardapio("Hambúrguer Artesanal", 
            "Pão brioche, blend 180g, queijo cheddar, bacon e molho especial", 32.50);
        
        ItemCardapio batataFrita = new ItemCardapio("Batata Frita", 
            "Porção de batata frita crocante com cheddar e bacon", 18.90);
        
        // Adicionando itens ao cardápio
        cardapio.adicionarItem(pizza);
        cardapio.adicionarItem(refrigerante);
        cardapio.adicionarItem(sobremesa);
        cardapio.adicionarItem(hamburguer);
        cardapio.adicionarItem(batataFrita);
        
        // Criando combos
        Combo comboJantar = new Combo("Combo Jantar", 
            "Pizza + Refrigerante + Sobremesa", 10.0);
        comboJantar.adicionarItem(pizza);
        comboJantar.adicionarItem(refrigerante);
        comboJantar.adicionarItem(sobremesa);
        
        Combo comboLanches = new Combo("Combo Lanche", 
            "Hambúrguer + Batata Frita + Refrigerante", 15.0);
        comboLanches.adicionarItem(hamburguer);
        comboLanches.adicionarItem(batataFrita);
        comboLanches.adicionarItem(refrigerante);
        
        Combo comboMaster = new Combo("Combo Master", 
            "Combo Jantar + Combo Lanche (para compartilhar)", 20.0);
        comboMaster.adicionarItem(comboJantar);
        comboMaster.adicionarItem(comboLanches);
        
        // Adicionando combos ao cardápio
        cardapio.adicionarItem(comboJantar);
        cardapio.adicionarItem(comboLanches);
        cardapio.adicionarItem(comboMaster);
        
        // Exibindo o cardápio completo
        cardapio.exibirCardapio();
        
        // Demonstração de cálculo de preço
        System.out.println("Preço do Combo Master: R$ " + String.format("%.2f", comboMaster.getPreco()));
        System.out.println("Economia: R$ " + String.format("%.2f", 
            (comboJantar.getPreco() + comboLanches.getPreco() - comboMaster.getPreco())));
    }
}