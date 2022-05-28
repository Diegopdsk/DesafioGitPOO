
package com.diego.desafiodiogft;

/**
 *
 * @author Diego
 */
public abstract class Conta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numero;
    protected Double saldo =0.0;
    protected Cliente cliente;
    
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
      
    
    public void sacar(Double valor){
        this.saldo -= valor;
    }
    
    public void depositar(Double valor){
        this.saldo += valor;
    }
    
    public void transferir(Double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
    protected String imprimirExtrato(){
        
        String ag = String.format(" Agencia: 00%d ", this.agencia);
        String num = String.format(" Conta: 00%d ", this.numero);
        String valorSaldo = String.format("Saldo é : %.2f ", this.saldo);
        
        return "Olá "+ this.cliente.getNome()+"\n"+ ag +num+"\n"+
                " O "+valorSaldo;
    }
    
    
}
