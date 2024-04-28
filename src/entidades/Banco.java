package entidades;
import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;
import entidades.Conta;
import entidades.Funcionario;
import entidades.Loja;

public class Banco {

    public static void main(String[] args) {
       
              // 1 banco
        Conta banco = new Conta(0);
        
        
         // Criar as contas das lojas
        Conta contaLoja1 = new Conta(0);
        Conta contaLoja2 = new Conta(0);
       
       
        
        
         Funcionario[] funcionariosLoja1 = {
        new Funcionario(new Conta(0),new Conta(0),1400),
       new Funcionario(new Conta(0),new Conta(0),1400 ) };
         
           // Criar os objetos Funcionario da loja 2
         Funcionario[] funcionariosLoja2 = {
       new Funcionario(new Conta(0),new Conta(0),1400 ),
       new Funcionario(new Conta(0),new Conta(0),1400)};
  
  
         // as 2 lojas
       Loja[] lojasPossiveis = {new Loja(contaLoja1,null),
       new Loja(contaLoja2,null)};
       
       lojasPossiveis[0].setFuncionarios(funcionariosLoja1);
       lojasPossiveis[1].setFuncionarios(funcionariosLoja2);
       
        
       
        
        
       // 6 clientes
      
       Cliente[] clientes = {new Cliente(new Conta(1000), lojasPossiveis),
        new Cliente(new Conta(1000),lojasPossiveis),
       new Cliente(new Conta(1000),lojasPossiveis),
       new Cliente(new Conta(1000),lojasPossiveis),
       new Cliente(new Conta(1000),lojasPossiveis),
       new Cliente(new Conta(1000),lojasPossiveis)};
     

   

   
       for (Cliente cliente : clientes){
           cliente.start();
           try {
                Thread.sleep(3000); // Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
           
       
       

       
       for(Funcionario funcionario : funcionariosLoja1){    
        funcionario.start();
        try {
                Thread.sleep(3000); // Aguarda 3 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
  
}  
       
       
  for(Funcionario funcionario : funcionariosLoja2){
        funcionario.start();
        try {
                Thread.sleep(3000); // Aguarda 3 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
  
}    
  
  
  
  
  
   
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
