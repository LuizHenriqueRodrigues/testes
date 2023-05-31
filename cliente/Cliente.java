package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import Util.MsgRequest;
import Util.MsgResponse;
import Util.Status;

public class Cliente {

        public static void main(String[] args) {
            Socket socket;
            int PORT = 12345;
            String HOST = "localhost";
            double value1;
            char escolha;

            Scanner entrada = new Scanner(System.in);


            

           try {
            socket = new Socket(HOST,PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            

            System.out.println("digite uma operação (I para impar e P para par): ");
            escolha = entrada.nextLine().charAt(0); // pega  apenas o primeiro caracter
            System.out.println("digite o primeiro numero");
            value1 = Double.parseDouble(entrada.nextLine());
            System.out.println("digite o segundo numero");
            Random nuRandom = new Random();
            int resposta = (int) (nuRandom.nextInt(5)+value1);

            System.out.println("Seu numero: "+value1);
            System.out.println("Numero do adversario: "+ (resposta - value1));
            System.out.println("Resultado: " + resposta);

            MsgRequest request = new MsgRequest(value1, nuRandom, escolha);
            
            out.writeObject(request);
            
            MsgResponse response = (MsgResponse) (in.readObject());

            
           } catch (Exception e) {
            
           } 




           entrada.close();
          


        }
}