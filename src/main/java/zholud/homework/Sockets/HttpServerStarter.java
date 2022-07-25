package zholud.homework.Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpServerStarter implements Runnable{

    public static void main(String[] args) {

    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                Logger.getLogger(HttpServerStarter.class.getName()).info("Client accepted");
                new Thread(new HttpServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}