package day004.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient1 {

   // bac code
   public static void main(String[] args) throws Exception {

      System.out.println("Client Start");
      
      Scanner keyScanner = new Scanner(System.in);
      
      Socket socket = new Socket("192.168.0.109", 5555);

      DataInputStream din = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      new Thread(() -> {

         try {
            for (int i = 0; i < 100; i++) {
               // 받은 메세지 출력
               String partnerMsg = din.readUTF();
               System.out.println(partnerMsg);

            }
         } catch (Exception e) {
            e.printStackTrace();

         }
      }).start();

      // read while

      // write while
      while (true) {

         // 키보드에서 보낸 메세지
         String myMsg = keyScanner.nextLine();

         // 읽은 메세지 전송
         dos.writeUTF(myMsg);
      }

   }

}