package moedas_cofrinho;

/**
 * Classe Dolar
 * Estende a classe abstrata Moeda.
 * Representa uma moeda americana (Dólar).
 */
public class Dolar extends Moeda {

    // Taxa de conversão para Real (exemplo: 1 Dólar = R$ 5.00)
    private static final double TAXA_DOLAR_REAL = 5.00;

    /**
     * Construtor da moeda Dólar.
     * @param valor O valor em US$ (ex: 1.00, 5.00).
     */
    public Dolar(double valor) {
        super(valor);
    }

    /**
     * Implementação do método info() para Dólar.
     */
    @Override
    public void info() {
        System.out.printf("Dólar - US$ %.2f\n", this.valor);
    }

    /**
     * Implementação do método converterParaReal() para Dólar.
     * Converte o valor do Dólar para Reais.
     * @return O valor da moeda em Reais.
     */
    @Override
    public double converterParaReal() {
        return this.valor * TAXA_DOLAR_REAL;
    }
}