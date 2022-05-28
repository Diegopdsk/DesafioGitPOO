
package com.diego.desafiodiogft;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Banco {
    private static final String NOME_BANCO = "Banco Poupe+";
            
    private String nome;
    private List<Conta> contas;

    public Banco() {
        this.nome = NOME_BANCO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    
    public  void operacaoFinanceira(Object operacao, Conta conta, Object contaSelecionada, Conta contaDestino){
     
        if(operacao == "Sacar"){
                Double valor =0.0;
                do{
                    try{
                        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja sacar"));
                    }catch(NumberFormatException e){

                        JOptionPane.showMessageDialog(null, "Digite um número válido\nCaso haja casas decimais, utilizar \".\" para separar. ");
                    }
                }while(valor==0.0);
                
                    conta.sacar(valor);
                    String msg = "Valor de R$ "+valor+ "0 retirado com Sucesso!";
                    JOptionPane.showMessageDialog(null, msg);

                    
            }else if(operacao == "Depositar"){
                  Double valor =0.0;
                do{
                    try{
                        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja Depositar"));
                    }catch(NumberFormatException e){

                        JOptionPane.showMessageDialog(null, "Digite um número válido\nCaso haja casas decimais, utilizar \".\" para separar. ");
                    }
                }while(valor==0.0);
                    
                    conta.depositar(valor);
                    
                    String msg = "Valor de R$ "+valor+ "0 depositado com Sucesso!";
                    JOptionPane.showMessageDialog(null, msg);                                
                    
                }else if(operacao == "Transferir"){
                      Double valor =0.0;
                do{
                    try{
                        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja Transferir"));
                    }catch(NumberFormatException e){

                        JOptionPane.showMessageDialog(null, "Digite um número válido\nCaso haja casas decimais, utilizar \".\" para separar. ");
                    }
                }while(valor==0.0);
                   
                    conta.transferir(valor, contaDestino);
                    
                    String msg = "Valor de R$ "+valor+ "0 transferido com Sucesso!";
                    JOptionPane.showMessageDialog(null, msg);
                    
                }else{
                    String msg = conta.imprimirExtrato();
                    JOptionPane.showMessageDialog(null, msg,contaSelecionada.toString(),JOptionPane.INFORMATION_MESSAGE);
                }
        

    }
    
}
