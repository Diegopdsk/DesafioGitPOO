
package com.diego.desafiodiogft;


import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Operacao {
    public static void main(String[] args) {
        String nome = "";
        String cpf = "";
        Double valor;
        int decisao = 0;
        Object[] tipoConta = {"Conta Corrente","Conta Poupança"};
        Object[] tipoDeOperacao = {"Sacar","Depositar","Transferir","Ver Saldo"};
                
        Banco poupeMais = new Banco();
        
        nome = JOptionPane.showInputDialog(null,"Olá tudo bem? Digite seu nome por favor"
                ,poupeMais.getNome(),JOptionPane.INFORMATION_MESSAGE);
        if(nome==null){
            
            System.exit(0);
        }
        
        do{
        cpf = JOptionPane.showInputDialog(null,"Agora Digite seu CPF",
                poupeMais.getNome(),JOptionPane.INFORMATION_MESSAGE);
            if(cpf==null){
            
            System.exit(0);
            }
                if(cpf.length()<11 || cpf.length() >11){
                    JOptionPane.showMessageDialog(null,"Digite um CPF Valido!",poupeMais.getNome(),JOptionPane.INFORMATION_MESSAGE);
                }
        }while(cpf.length()<11 || cpf.length() >11);
       
        
        Cliente cliente = new Cliente();
               
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        
        Object contaSelecionada = JOptionPane.showInputDialog(null,
             "Pra qual tipo de Conta deseja Atendimento?", poupeMais.getNome(),
             JOptionPane.INFORMATION_MESSAGE, null,
             tipoConta, tipoConta[0]);
        
        Conta contaCorrente = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);
        
        do{
        
            if(contaSelecionada == "Conta Corrente"){
                Conta conta = contaCorrente;
                Object operacao = JOptionPane.showInputDialog(null,
                 "Que tipo de operação deseja fazer?", poupeMais.getNome(),
                 JOptionPane.INFORMATION_MESSAGE, null,
                 tipoDeOperacao, tipoDeOperacao[0]);



                poupeMais.operacaoFinanceira(operacao, conta, contaSelecionada,poupanca);
                decisao = JOptionPane.showConfirmDialog(null, "Deseja fazer outra Operação?",contaSelecionada.toString(),JOptionPane.YES_NO_OPTION);


            }else{
                Conta conta = poupanca; 
                Object operacao = JOptionPane.showInputDialog(null,
                 "Que tipo de operação deseja fazer?", "Input",
                 JOptionPane.INFORMATION_MESSAGE, null,
                 tipoDeOperacao, tipoDeOperacao[0]);

                poupeMais.operacaoFinanceira(operacao, conta, contaSelecionada,contaCorrente);
                decisao = JOptionPane.showConfirmDialog(null, "Deseja fazer outra Operação?",contaSelecionada.toString(),JOptionPane.YES_NO_OPTION);

            }
        }while(decisao==0);
    }

}
