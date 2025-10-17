package moedas_cofrinho;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Menu
 * Contém o método main para iniciar o programa e a interface com o usuário.
 */
public class Menu {

    private Scanner scanner;
    private Cofrinho cofrinho;

    /**
     * Construtor da classe Menu.
     * Inicializa o Scanner e o Cofrinho.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.cofrinho = new Cofrinho();
    }

    /**
     * Exibe o menu principal e gerencia a interação do usuário.
     */
    public void exibirMenuPrincipal() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n==================================");
            System.out.println("      Sistema Cofrinho de Moedas    ");
            System.out.println("==================================");
            System.out.println("1 - Adicionar Moeda");
            System.out.println("2 - Remover Moeda");
            System.out.println("3 - Listar Moedas");
            System.out.println("4 - Calcular Total Convertido para Real");
            System.out.println("5 - Sair");
            System.out.println("==================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                switch (opcao) {
                    case 1:
                        menuAdicionarMoeda();
                        break;
                    case 2:
                        menuRemoverMoeda();
                        break;
                    case 3:
                        cofrinho.listarMoedas();
                        break;
                    case 4:
                        double total = cofrinho.totalConvertidoParaReal();
                        System.out.printf("O total no cofrinho, convertido para Real, é: R$ %.2f\n", total);
                        break;
                    case 5:
                        System.out.println("Encerrando o sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer
                opcao = 0; // Volta para o menu
            }
        }
    }

    /**
     * Submenu para adicionar moedas.
     */
    private void menuAdicionarMoeda() {
        System.out.println("\n--- Adicionar Moeda ---");
        System.out.println("1 - Real");
        System.out.println("2 - Dólar");
        System.out.println("3 - Euro");
        System.out.print("Escolha o tipo de moeda: ");

        try {
            int tipoMoeda = scanner.nextInt();
            System.out.print("Digite o valor da moeda (ex: 1.00, 0.50): ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            if (valor <= 0) {
                System.out.println("Valor deve ser positivo.");
                return;
            }

            Moeda novaMoeda = null;

            switch (tipoMoeda) {
                case 1:
                    // Instancia um Real, mas armazena em uma referência Moeda (Polimorfismo)
                    novaMoeda = new Real(valor);
                    break;
                case 2:
                    // Instancia um Dolar, mas armazena em uma referência Moeda (Polimorfismo)
                    novaMoeda = new Dolar(valor);
                    break;
                case 3:
                    // Instancia um Euro, mas armazena em uma referência Moeda (Polimorfismo)
                    novaMoeda = new Euro(valor);
                    break;
                default:
                    System.out.println("Tipo de moeda inválido.");
                    return;
            }

            cofrinho.adicionar(novaMoeda);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar números para o valor.");
            scanner.nextLine();
        }
    }

    /**
     * Submenu para remover moedas.
     */
    private void menuRemoverMoeda() {
        System.out.println("\n--- Remover Moeda ---");
        System.out.println("1 - Real");
        System.out.println("2 - Dólar");
        System.out.println("3 - Euro");
        System.out.print("Escolha o tipo de moeda a remover: ");

        try {
            int tipoMoeda = scanner.nextInt();
            System.out.print("Digite o valor da moeda (ex: 1.00, 0.50): ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            if (valor <= 0) {
                System.out.println("Valor deve ser positivo.");
                return;
            }

            Moeda moedaParaRemover = null;

            // Cria uma "moeda temporária" para buscar e remover uma equivalente na lista
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

            cofrinho.remover(moedaParaRemover);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar números para o valor.");
            scanner.nextLine();
        }
    }

    /**
     * Método principal que executa o programa.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenuPrincipal();
    }

}