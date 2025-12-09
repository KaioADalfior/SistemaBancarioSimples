import java.util.ArrayList;
import java.util.List;

public class Banco {
    
    private List<ContaBancaria> contas;

    public Banco(){
        this.contas = new ArrayList<>();
    }

    public void cadastrarConta(ContaBancaria novaConta){

        this.contas.add(novaConta);
    }

    public void listarClientes(){

        if(contas.isEmpty()){
            System.out.println("\n--- Lista de Clientes ---");
            System.out.println("\n--- Nenhum Cliente Cadastrado no momento ---");
            return;
        }

        System.out.println("\n--- Lista de Clientes ---");
        for(ContaBancaria conta : contas){
            System.out.printf("Conta: %s | Titular  %s | Saldo: R$ %.2f%n", 
                conta.getNumeroConta(), conta.getTitular(), conta.getSaldo());
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {

        for(ContaBancaria conta : this.contas){
            if(conta.getNumeroConta().equals(numeroConta)){
                return conta;
            }
        }
        return null;
    }
}
