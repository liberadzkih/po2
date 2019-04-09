package po2_zad8;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class TCP_Client {
    
    static Socket clientSocket;
    
    public static void main(String[] args) throws Exception {
        try{
            clientSocket = new Socket("127.0.0.1", 5555);
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            byte[] bytes = new byte[1024];
            int bytesRead = in.read(bytes);
            String modifiedMsg = new String(bytes, 0, bytesRead);
            System.out.println("FROM SERVER: " + modifiedMsg);
            clientSocket.close();
        } catch(IOException e){
            e.printStackTrace(System.err);
            System.err.println("Something went wrong");
        }
        
   }                                                                                   
}