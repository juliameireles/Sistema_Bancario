package entidades;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Conta {
    private float saldo;
    private final Lock lock = new ReentrantLock();
    
    
    //Construtor
    // Incializa o objeto Conta. Ele sera chamado automaticamente quando um objeto Conta for criado
    public Conta (int saldoInicial){
        this.saldo = saldoInicial;
    }
    
    public void depositando(float valor){
        lock.lock(); // usado para exclusao mutua
        try{
            saldo += valor;
        }finally{
            lock.unlock();
        }
    }
    public void sacando(float valor){
        lock.lock();
        try{
            if (saldo>=valor){
                saldo -=valor;
            }
            }finally{
                    lock.unlock();
                    }
        
    }
    
     public float getSaldo() {
        return saldo;
    }
     
     
     
     
}
        
        
        
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    

