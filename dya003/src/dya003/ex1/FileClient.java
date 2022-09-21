package dya003.ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.Cleanup;

public class FileClient {

   public static void main(String[] args) throws Exception {

      Scanner keyScanner = new Scanner(System.in);

      System.out.println("fileName");
      String oper = keyScanner.nextLine();

      @Cleanup
      Socket socket = new Socket("192.168.0.120", 5555);
      @Cleanup
      DataInputStream din = new DataInputStream(socket.getInputStream());
      @Cleanup
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      dos.writeUTF(oper);

      String status = din.readUTF(); // 상태코드

      System.out.println(status);

      if (status.equals("404")) {
         System.out.println("해당파일은 서버에없음");
      } else if (status.equals("200")) {

         String fileName = oper;
         @Cleanup
         FileOutputStream fos = new FileOutputStream("C:\\zzz2\\" + fileName);

         byte[] buffer = new byte[1024 * 8];

         while (true) {
            int count = din.read(buffer);
            if (count == -1) {
               break;
            }
            fos.write(buffer, 0, count);
         }

      }

   }
}
