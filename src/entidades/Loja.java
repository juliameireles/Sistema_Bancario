package entidades;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Cada loja:
● Deve possuir uma conta, para receber os pagamentos dos clientes;
● Deve pagar os funcionários assim que possuir o valor dos seus salários (R$ 1.400,00);
*/

public class Loja {
    private Conta contaLoja; // Variável para armazenar a conta da loja
    private Funcionario[] funcionarios;// array que representa os funcionarios da loja
     private Lock lock = new ReentrantLock();


 //CONSTRUTOR
//Incializa o objeto Loja. Ele sera chamado automaticamente quando um objeto Loja for criado e inicializara os atributps contaLoja e funcionarios com os valores passados como argumento
public Loja(Conta contaLoja, Funcionario[] funcionarios){
   this.contaLoja = contaLoja;
  this.funcionarios = funcionarios; 
}
// Método para definir a conta da loja
    public void setConta(Conta contaLoja) { // Metodo conta que recebe uma instancia da classe Conta
        this.contaLoja = contaLoja;
    }
    
 public Conta getConta(){
     return contaLoja;
 }

 public void pagarFuncionarios(){ // metodo responsavel por pagar os funcionario da loja 
     lock.lock();
     boolean saldoVazio = false;
     int lojaIndex = 0;
     int i = 0;
     while(!saldoVazio && i <funcionarios.length){
     System.out.println("A conta da Loja " +lojaIndex+ " tem atualmente: "+contaLoja.getSaldo());
     try{
     synchronized (contaLoja){
          //float totalSalarios = calcularTotalSalarios();
      if (contaLoja.getSaldo() >=  1400){
          contaLoja.sacando(1400); //Subtrai o valor dos salários do saldo da conta  
             System.out.println("Salários pago ao funcionário" +funcionarios[i] +" com sucesso!");
              System.out.println("Apos pagar o funcionario" +funcionarios[i]+", a  conta da Loja " +lojaIndex+ " tem atualmente: "+contaLoja.getSaldo());
             lojaIndex = lojaIndex + 1;
             i++;
      }else {
             saldoVazio = true;
            System.out.println("Saldo insuficiente para pagar os salários dos funcionários.");
        }
 }  }finally{
         lock.unlock();
     }
 
 }  
 }
     // Método para calcular o total dos salários dos funcionários
    //private float calcularTotalSalarios() {// Responsavel por calcular a soma dos salarios de cada funcionario. No caso desse sistema, sera 4 funcionarios
       //float totalSalarios = 0;
       // for (int i = 0; i<funcionarios.length;i++) {
         //  totalSalarios += funcionarios[i].getSalario();
        //}
      //  return totalSalarios;
    //}
    
     public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }




}














