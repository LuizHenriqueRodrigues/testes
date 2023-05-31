package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import Util.MsgRequest;
import Util.MsgResponse;

public class ThreadImparOuPar extends Thread{
   
   Socket cliente;
   
   public ThreadImparOuPar(Socket cliente){
    this.cliente = cliente;
   }
   
    @Override
    public void run() {
        System.out.println("conectado ao client: " + cliente.getInetAddress().getHostAddress());
        
        try {
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
        
         MsgRequest request = (MsgRequest) in.readObject();
         
         
         char escolha = request.getEscolha();
         double valeu1 = request.getValue1();
         Random nuRandom = request.getNuRandom();
         double resp;
         MsgResponse response;
        
        
        
         switch (escolha) {
            case 'P':
                
                break;
        
            default:
                break;
        }
        } catch (Exception e) {
            
        }


    }
}
