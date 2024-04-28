package entidades;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Funcionario extends Thread {
    private Conta contaSalario; // Conta para receber o salário da loja
    private Conta contaInvestimento; // Conta para investir o salário
    private float salario = 1400;
    private Lock lock = new ReentrantLock(); // Criação do lock

    // CONSTRUTOR DO OBJETO FUNCIONARIO
    public Funcionario(Conta contaSalario, Conta contaInvestimento, float salario) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.salario = salario;
       
    }

    @Override
    public void run() { // execução da thread 
        lock.lock();
        try {
            receberSalario();
            investir();
        } finally {
            lock.unlock(); // Libera o lock
        }
    }

    // Método para receber o salário e investir 20% na conta de investimento
    private void receberSalario() {
        contaSalario.depositando(salario);
        //float valorInvestimento = salario * 0.2f;
        //contaSalario.sacando(valorInvestimento);
        //contaInvestimento.depositando(valorInvestimento);
        System.out.println("Funcionário " + getId() + " recebeu salário de " +salario );
        System.out.println("Conta salário do funcionário atualmente: " + contaSalario.getSaldo());
    }
    
    private void investir(){
        float valorInvestimento = salario * 0.2f;
        contaSalario.sacando(valorInvestimento);
        contaInvestimento.depositando(valorInvestimento);
        System.out.println("Funcionario resolveu investir e agora sua conta investimento tem 20% do seu salario: "+contaInvestimento.getSaldo());
        
    }
    
    

    @Override
    public void start() {
        super.start();
    }

    public float getSalario() {
        return salario;
    }
}
