public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private String cpf;
    private double saldo;

    public ContaBancaria(String titular, String numeroConta, String cpf){
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.cpf = cpf;
        this.saldo = 0.00;
    }

    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
        } 
        else {
            System.out.println("Valor de depósito inválido.");
        } 	
    }

    public void sacar(double valor){
        if(valor > 0 && valor <= saldo){
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo); 	

        }else if(valor > saldo){
            System.out.println("Saldo insuficiente para saque!"); // Corrigido de "Salfo" para "Saldo"

        }else{
            System.out.println("Valor de saque inválido!");
        }
    }

    public String getTitular(){
        return titular;
    }

    public String getNumeroConta(){
        return numeroConta;
    }

    public double getSaldo(){
        return saldo;
    }
    public String getCpf(){
    return cpf;
}
}