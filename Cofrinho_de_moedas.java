// Implementação das classes de moeda
public abstract class Moeda {
    // Atributo 'valor' para armazenar o valor da moeda (ex: 10.50)
    protected double valor;

    // Construtor
    public Moeda(double valor) {
        this.valor = valor;
    }

    // Método abstrato para obter informações sobre a moeda
    // Será implementado por cada subclasse (ex: "Dólar - $10.00")
    public abstract String info();

    // Método abstrato PRINCIPAL: calcula o valor da moeda convertido para Real.
    // ESTE MÉTODO DEMONSTRA O POLIMORFISMO!
    public abstract double converter();

    // Método equals para facilitar a remoção de moedas específicas do cofrinho
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda outraMoeda = (Moeda) obj;
        // Consideramos moedas iguais se forem do mesmo tipo e tiverem o mesmo valor
        return Double.compare(outraMoeda.valor, valor) == 0;
    }

    // Getter para o valor (opcional, mas útil)
    public double getValor() {
        return valor;
    }
}
// Taxa de conversão simulada: 1 Dólar = 5.00 Reais
public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Dólar (USD) - $" + String.format("%.2f", valor);
    }

    // Implementação Polimórfica: Converte Dólar para Real
    @Override
    public double converter() {
        return this.valor * 5.00;
    }
}
// Taxa de conversão simulada: 1 Euro = 6.00 Reais
public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Euro (EUR) - €" + String.format("%.2f", valor);
    }

    // Implementação Polimórfica: Converte Euro para Real
    @Override
    public double converter() {
        return this.valor * 6.00;
    }
}
// Taxa de conversão: 1 Real = 1 Real
public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Real (BRL) - R$" + String.format("%.2f", valor);
    }

    // Implementação Polimórfica: Já está em Real, retorna o próprio valor
    @Override
    public double converter() {
        return this.valor;
    }
}
// Implementação da classe cofrinho
import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    // Atributo: Coleção de Moedas
    private List<Moeda> listaMoedas;

    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    // Método Adicionar
    public void adicionar(Moeda m) {
        this.listaMoedas.add(m);
        System.out.println("Moeda adicionada: " + m.info());
    }

    // Método Remover
    public void remover(Moeda m) {
        // A remoção funciona graças ao método equals implementado em Moeda!
        if (this.listaMoedas.remove(m)) {
            System.out.println("Moeda removida: " + m.info());
        } else {
            System.out.println("ERRO: Moeda não encontrada no cofrinho.");
        }
    }

    // Método Listagem de Moedas
    public void listagemMoedas() {
        if (this.listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio!");
            return;
        }

        System.out.println("\n--- Moedas no Cofrinho ---");
        for (Moeda m : this.listaMoedas) {
            System.out.println(m.info());
        }
        System.out.println("--------------------------");
    }

    // Método Total Convertido para Real
    public void totalConvertido() {
        double totalEmReal = 0;

        // O Polimorfismo acontece aqui! O método converter() chamado será o
        // da classe específica (Dolar, Euro ou Real)
        for (Moeda m : this.listaMoedas) {
            totalEmReal += m.converter();
        }

        System.out.println("\n--- Total Convertido ---");
        System.out.println("Total no cofrinho (convertido para R$): R$" + String.format("%.2f", totalEmReal));
        System.out.println("--------------------------");
    }
}
// Implementação da classe Principal Menu
import java.util.Scanner;

public class Principal {
    private static Cofrinho cofrinho = new Cofrinho();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenuPrincipal();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha
                processarOpcao(opcao);
            } else {
                System.out.println("\nOpção inválida! Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer
                opcao = 0; // Garante que o loop continue
            }
        } while (opcao != 0);

        System.out.println("Obrigado por usar o Cofrinho! Programa encerrado.");
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n==============================");
        System.out.println("        COFRINHO DIGITAL        ");
        System.out.println("==============================");
        System.out.println("1 - Adicionar Moeda");
        System.out.println("2 - Remover Moeda");
        System.out.println("3 - Listar Moedas");
        System.out.println("4 - Calcular Total Convertido para Real");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                menuAdicionarMoeda();
                break;
            case 2:
                menuRemoverMoeda();
                break;
            case 3:
                cofrinho.listagemMoedas();
                break;
            case 4:
                cofrinho.totalConvertido();
                break;
            case 0:
                // Sai do loop no main
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
    
    // --- Métodos de Interação para Adicionar/Remover ---

    private static void menuAdicionarMoeda() {
        System.out.println("\n--- ADICIONAR MOEDA ---");
        System.out.println("1 - Real");
        System.out.println("2 - Dólar");
        System.out.println("3 - Euro");
        System.out.print("Escolha o tipo de moeda: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Opção inválida.");
            scanner.nextLine();
            return;
        }
        int tipoMoeda = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Digite o valor da moeda (ex: 10.50): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido.");
            scanner.nextLine();
            return;
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Moeda novaMoeda = null;
        switch (tipoMoeda) {
            case 1:
                novaMoeda = new Real(valor);
                break;
            case 2:
                novaMoeda = new Dolar(valor);
                break;
            case 3:
                novaMoeda = new Euro(valor);
                break;
            default:
                System.out.println("Tipo de moeda inválido.");
                return;
        }

        cofrinho.adicionar(novaMoeda);
    }

    private static void menuRemoverMoeda() {
        System.out.println("\n--- REMOVER MOEDA ---");
        System.out.println("1 - Real");
        System.out.println("2 - Dólar");
        System.out.println("3 - Euro");
        System.out.print("Escolha o tipo de moeda a ser removida: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Opção inválida.");
            scanner.nextLine();
            return;
        }
        int tipoMoeda = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Digite o valor da moeda a ser removida (ex: 10.50): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido.");
            scanner.nextLine();
            return;
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Moeda moedaParaRemover = null;
        switch (tipoMoeda) {
            case 1:
                moedaParaRemover = new Real(valor);
                break;
            case 2:
                moedaParaRemover = new Dolar(valor);
                break;
            case 3:
                moedaParaRemover = new Euro(valor);
                break;
            default:
                System.out.println("Tipo de moeda inválido.");
                return;
        }
        
        // Remove a instância, utilizando o método equals
        cofrinho.remover(moedaParaRemover);
    }
}
