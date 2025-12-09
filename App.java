import java.util.Scanner;

public class App { 
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        
        int opcao = 0;
        
        while (opcao != 4){
            System.out.println("\n===== Sistema Bancário =====");
            System.out.println("1. Cadastrar Novo Cliente");
            System.out.println("2. Acessar Conta Existente");
            System.out.println("3. Listar Todos os Clientes (Admin)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            if(scanner.hasNextInt()){
                opcao = scanner.nextInt();
                scanner.nextLine(); 

            }else{
                System.out.println("Opção inválida! Tente novamente digitando um número!");
                scanner.nextLine(); 
                continue; 
            }

            switch (opcao){
                case 1:
                    cadastrarCliente(scanner, banco);
                    break;

                case 2:
                    acessarConta(scanner, banco); // Corrigido para camelCase
                    break;
                
                case 3:
                    banco.listarClientes(); 
                    break;

                case 4:
                    System.out.println("Obrigado por usar o Sistema Bancário!. Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente."); 	
            }
        }
        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner, Banco banco){
        System.out.println("\n--- CADASTRO DE NOVO CLIENTE ---");

        System.out.print("Nome do Titular: ");
        String titular = scanner.nextLine();

        System.out.print("Número da Conta: (Ex: 1003) ");
        String numConta = scanner.nextLine(); 

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria novaConta = new ContaBancaria(titular, numConta, cpf);
        
        banco.cadastrarConta(novaConta);

        System.out.println("Cliente: " + titular + " com número de conta " + numConta + " cadastrado com sucesso!"); 	
    } 	


    private static void acessarConta(Scanner scanner, Banco banco){ 

        System.out.println("\n--- ACESSO À CONTA ---");
        System.out.print("Digite o Número da Conta: ");
        String numConta = scanner.nextLine();

        ContaBancaria contaLogada = banco.buscarConta(numConta);

        if(contaLogada != null){
            System.out.println("\nBem-vindo (a), " + contaLogada.getTitular() + ".");

            menuOperacoes(scanner, contaLogada); 

        }else{
            System.out.println("\n❌ ERRO: Conta não encontrada! Verfifique o número da conta!");
        }
    }


    private static void menuOperacoes(Scanner scanner, ContaBancaria conta) {
        int op = 0;
        while (op != 4) {
            System.out.println("\n--- Operações de " + conta.getTitular() + " ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma operação: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida.");
                scanner.nextLine();
                continue;
            }

            switch (op) {
                case 1:
                    System.out.printf("Saldo Atual: R$ %.2f%n", conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: R$ ");
                    if (scanner.hasNextDouble()) {
                        conta.depositar(scanner.nextDouble());
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: R$ ");
                    if (scanner.hasNextDouble()) {
                        conta.sacar(scanner.nextDouble());
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}