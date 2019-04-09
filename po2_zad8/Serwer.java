package po2_zad8;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Serwer {
    public static void main(String argv[]) throws Exception {
        String clientSentence = "";
        ServerSocket welcomeSocket = new ServerSocket(5555);
        int counter = 0;
        
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat data_df = new SimpleDateFormat("yyyy.MM.dd");
            clientSentence += "Data: " + data_df.format(cal.getTime());
            
            SimpleDateFormat time_df = new SimpleDateFormat("HH:mm:SS");
            clientSentence += "Godzina: " + time_df.format(cal.getTime());
            
            counter++;
            clientSentence += "Jestes klientem #" + counter;
            
            byte bufor[] = clientSentence.getBytes(Charset.forName("UTF-8"));
            DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
            out.write(bufor);
            connectionSocket.close();
        }
    }
}