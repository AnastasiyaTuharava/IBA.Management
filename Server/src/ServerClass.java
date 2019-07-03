import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
        public static void main(String[] arg) {
            ServerSocket serverSocket = null;
            Socket clientAccepted = null;
            ObjectInputStream sois = null;
            ObjectOutputStream soos =null;
            try {
                serverSocket = new ServerSocket(2525);
                System.out.println("server starting....");
                clientAccepted = serverSocket.accept();
                System.out.println("connection established....");
                sois=new ObjectInputStream(clientAccepted.getInputStream());
                soos=new ObjectOutputStream(clientAccepted.getOutputStream());
                String clientMessageRecieved = (String) sois.readObject();
                while (!clientMessageRecieved.equals("quite")){
                    System.out.println("message recieved:" + clientMessageRecieved);
                    clientMessageRecieved=clientMessageRecieved.toUpperCase();
                    soos.writeObject(clientMessageRecieved);
                    clientMessageRecieved = (String) sois.readObject();
                }
            } catch (IOException | ClassNotFoundException e) {
            } finally {
                try {
                    if (sois != null)sois.close();
                    if (soos != null) soos.close();
                    if (clientAccepted != null)clientAccepted.close();
                    if (serverSocket != null) serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Ресурсы не закрыты!!!");
                }
            }
        }
    }
