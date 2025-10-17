package moedas_cofrinho;

/**
 * Classe Real
 * Estende a classe abstrata Moeda.
 * Representa uma moeda brasileira.
 */
public class Real extends Moeda {

    /**
     * Construtor da moeda Real.
     * @param valor O valor em R$ (ex: 0.50, 1.00).
     */
    public Real(double valor) {
        super(valor);
    }

    /**
     * Implementação do método info() para Real.
     */
    @Override
    public void info() {
        System.out.printf("Real - R$ %.2f\n", this.valor);
    }

    /**
     * Implementação do método converterParaReal() para Real.
     * O valor do Real para Real é ele mesmo (conversão 1:1).
     * @return O valor da moeda em Reais.
     */
    @Override
    public double converterParaReal() {
        return this.valor;
    }
}