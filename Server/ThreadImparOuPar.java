package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import Util.MsgRequest;
import Util.MsgResponse;

public class ThreadImparOuPar extends Thread {
   private int ganhou;
   private int perdeu;
   private Socket cliente;
   
   public ThreadImparOuPar(Socket cliente) {
      this.cliente = cliente;
      ganhou = 0;
      perdeu = 0;
   }
   
    @Override
    public void run() {
        System.out.println("Conectado ao cliente: " + cliente.getInetAddress().getHostAddress());
        
        try {
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
        
            MsgRequest request = (MsgRequest) in.readObject();
         
            char escolha = request.getEscolha();
            double valor1 = request.getValue1();
            Random nuRandom = request.getNuRandom();
            double resp;
            MsgResponse response;
            
            switch (escolha) {
                case 'P':
                    resp = jogarPar(nuRandom, valor1);
                    response = new MsgResponse(null, resp);
                    response.setResultado(resp % 2 == 0 ? "Par" : "Ímpar"); // Definir o resultado como "Par" ou "Ímpar"
                    out.writeObject(response);
                    break;
                    
                case 'I':
                    resp = jogarImpar(nuRandom, valor1);
                    response = new MsgResponse(null, resp);
                    response.setResultado(resp % 2 != 0 ? "Ímpar" : "Par"); // Definir o resultado como "Ímpar" ou "Par"
                    out.writeObject(response);
                    break;
        
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
            
            in.close();
            out.close();
            cliente.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Contador de vitórias: " + ganhou);
        System.out.println("Contador de derrotas: " + perdeu);
    }
    
    private double jogarPar(Random nuRandom, double valor1) {
        double valorComputador = nuRandom.nextDouble() * 10;  // Gera um número aleatório para o computador
        double soma = valor1 + valorComputador;
        
        if (soma % 2 == 0) {
            System.out.println("A soma é par.");
            ganhou++; // Incrementar o contador de vitórias
            return soma;
        } else {
            System.out.println("A soma é ímpar.");
            perdeu++; // Incrementar o contador de derrotas
            return -soma;
        }
    }
    
    private double jogarImpar(Random nuRandom, double valor1) {
        double valorComputador = nuRandom.nextDouble() * 10;  // Gera um número aleatório para o computador
        double soma = valor1 + valorComputador;
        
        if (soma % 2 != 0) {
            System.out.println("A soma é ímpar.");
            ganhou++; // Incrementar o contador de vitórias
            return soma;
        } else {
            System.out.println("A soma é par.");
            perdeu++; // Incrementar o contador de derrotas
            return -soma;
        }
    }
    
    public int getGanhou() {
        return ganhou;
    }
    
    public int getPerdeu() {
        return perdeu;
    }
}
