import java.io.*;
import java.net.*;
//wjwssb
public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器已启动，等待客户端连接...");

            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            while (true) {
                if ((clientMessage = reader.readLine()) != null) {
                    System.out.println("客户端: " + clientMessage);
                }

                serverMessage = consoleReader.readLine();
                writer.println(serverMessage);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
