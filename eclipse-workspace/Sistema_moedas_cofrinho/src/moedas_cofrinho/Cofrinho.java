package moedas_cofrinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Cofrinho
 * Gerencia a coleção de moedas e as operações.
 */
public class Cofrinho {

    // Coleção (ArrayList) para armazenar objetos do tipo Moeda.
    // O ArrayList armazena diferentes tipos de moedas (Real, Dolar, Euro, etc.)
    // como se fossem todos do tipo Moeda, demonstrando o Polimorfismo.
    private List<Moeda> listaMoedas;

    /**
     * Construtor da classe Cofrinho. Inicializa o ArrayList.
     */
    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    /**
     * Adiciona uma Moeda ao cofrinho.
     * @param moeda O objeto Moeda (pode ser Real, Dolar, Euro, etc.) a ser adicionado.
     */
    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
        System.out.println("Moeda adicionada com sucesso!");
    }

    /**
     * Remove uma Moeda específica do cofrinho.
     * @param moeda O objeto Moeda (pode ser Real, Dolar, Euro, etc.) a ser removido.
     */
    public void remover(Moeda moeda) {
        // Usa o método equals() definido na classe Moeda para saber se a remoção é possível.
        if (this.listaMoedas.remove(moeda)) {
            System.out.println("Moeda removida com sucesso!");
        } else {
            System.out.println("Erro: Moeda não encontrada no cofrinho.");
        }
    }

    /**
     * Lista todas as moedas presentes no cofrinho.
     * Usa o método info() de cada objeto, que é uma chamada polimórfica.
     */
    public void listarMoedas() {
        if (this.listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }

        System.out.println("\n--- Moedas no Cofrinho ---");
        for (Moeda moeda : listaMoedas) {
            // Chamada Polimórfica: o método info() executado é o da classe real
            // do objeto (Real, Dolar, Euro...), não o da classe mãe Moeda.
            moeda.info();
        }
        System.out.println("--------------------------");
    }

    /**
     * Calcula o valor total de dinheiro no cofrinho, convertido para Real (R$).
     * Usa o método converterParaReal() de cada objeto, que é uma chamada polimórfica.
     * @return O valor total em Reais.
     */
    public double totalConvertidoParaReal() {
        if (this.listaMoedas.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (Moeda moeda : listaMoedas) {
            // Chamada Polimórfica: o método converterParaReal() executado é o da classe
            // real do objeto, que sabe como converter seu valor para Real.
            total += moeda.converterParaReal();
        }
        return total;
    }
}