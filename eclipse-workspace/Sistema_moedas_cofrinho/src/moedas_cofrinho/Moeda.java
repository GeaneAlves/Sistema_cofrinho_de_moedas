package moedas_cofrinho;
/**
 * Classe Abstrata Moeda
 * É a classe mãe que define a estrutura básica de qualquer moeda no cofrinho.
 * Implementa o conceito de Herança.
 */
public abstract class Moeda {

    // Atributo privado para armazenar o valor da moeda
    protected double valor;

    /**
     * Construtor da classe Moeda.
     * @param valor O valor nominal da moeda (ex: 0.50, 1.00, 2.00).
     */
    public Moeda(double valor) {
        this.valor = valor;
    }

    /**
     * Método Abstrato `info()`.
     * Força todas as classes filhas (Real, Dolar, Euro, etc.) a
     * implementar a forma como a informação da moeda será exibida.
     * Implementa o conceito de Polimorfismo.
     */
    public abstract void info();

    /**
     * Método Abstrato `converterParaReal()`.
     * Força todas as classes filhas a implementar a lógica de conversão
     * do seu valor para a moeda base (Real).
     * Implementa o conceito de Polimorfismo.
     * @return O valor da moeda convertido para Reais (R$).
     */
    public abstract double converterParaReal();

    /**
     * Getter para o valor da moeda.
     * @return O valor nominal da moeda.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método equals para permitir que a remoção funcione corretamente
     * ao comparar duas instâncias de Moeda (mesmo valor e tipo).
     * @param obj O objeto a ser comparado.
     * @return true se forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda outraMoeda = (Moeda) obj;
        return Double.compare(outraMoeda.valor, valor) == 0;
    }
}