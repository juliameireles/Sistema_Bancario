package entidades;
import java.util.Arrays; // para trabalhar com arrays
import java.util.List; // para trabalhar com listas
import java.util.Random; // para trabalhar com numeros aleatorios


/*
Cada cliente:
● Deve ser uma thread; CHECK
● Deve possuir uma conta com um saldo inicial de R$ 1.000,00; CHECK
● Deve realizar compras, de R$ 100,00 ou R$ 200,00, alternando as lojas, até o saldo da conta estar CHECK 
vazio.
*/


public class Cliente extends Thread{ // Classe Cliente eh uma thread
    private Conta santander ; // atributo que representa a conta do cliente 
    private Loja[] lojas; // representa as lojas possveis que os clientes podem realizar suas compras 
  
    
    public Cliente(Conta santander, Loja[] lojas){
       
        this.santander = santander;
        this.lojas = lojas;
       
    }
   
    @Override
    public void run(){
        
    Random random = new Random();
    boolean saldoVazio = false; // variavel usada para controlar se o saldo do cliente esta vazio
    int[] valoresPossiveis = {100, 200}; // Array com os valores das compras
    int lojaIndex = 0; // variavel que sera usada para alternar entre as lojas disponiveis
        
      while(!saldoVazio){ // enquanto o saldo nao estiver vazio, faça:
          
          int valorDaCompra = valoresPossiveis[random.nextInt(valoresPossiveis.length)]; // Seleciona uma valor aleatorio do array valoresPossiveis
          
          // Realizando a compra
          if(santander.getSaldo() >= valorDaCompra){
              santander.sacando(valorDaCompra);
              
             
              // Mostra a compra realizada
              System.out.println("O cliente "+this.getId()+ " acabou de realizar uma compra na loja " +lojaIndex+ " de R$"+valorDaCompra);
              System.out.println("Isso eh o que sobrou da conta dele: "+santander.getSaldo());
             
          
             // vai para a proxima loja
             lojaIndex = (lojaIndex + 1) % lojas.length;
          
          
          }else{
              saldoVazio = true;   
    }
      
     
      }
   
      
    }
    
    public void start() {
        super.start();
    }
    
    
      public Conta getConta(){
          return santander;
      }
}
