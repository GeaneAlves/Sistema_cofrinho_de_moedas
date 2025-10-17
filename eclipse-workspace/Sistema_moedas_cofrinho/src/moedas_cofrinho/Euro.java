package moedas_cofrinho;

/**
 * Classe Euro
 * Estende a classe abstrata Moeda.
 * Representa uma moeda europeia (Euro).
 */
public class Euro extends Moeda {

    // Taxa de conversão para Real (exemplo: 1 Euro = R$ 5.50)
    private static final double TAXA_EURO_REAL = 5.50;

    /**
     * Construtor da moeda Euro.
     * @param valor O valor em € (ex: 0.50, 1.00).
     */
    public Euro(double valor) {
        super(valor);
    }

    /**
     * Implementação do método info() para Euro.
     */
    @Override
    public void info() {
        System.out.printf("Euro - € %.2f\n", this.valor);
    }

    /**
     * Implementação do método converterParaReal() para Euro.
     * Converte o valor do Euro para Reais.
     * @return O valor da moeda em Reais.
     */
    @Override
    public double converterParaReal() {
        return this.valor * TAXA_EURO_REAL;
    }
}