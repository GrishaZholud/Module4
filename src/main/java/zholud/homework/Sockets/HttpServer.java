package zholud.homework.Sockets;


import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;


public class HttpServer implements Runnable {

    private final static String FILENAME = "C:\\Users\\grigo\\IdeaProjects\\Homeworks\\src\\main\\java\\zholud\\homeworks\\Sockets\\file.html";
    private final static Logger LOGGER = Logger.getLogger(HttpServer.class.getName());
    private final static String OK = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html\r\n" +
            "Connection: close\r\n\r\n";
    private final static String BADREQUEST = "HTTP/1.1 400 Bad Request\r\n" +
            "Content-Type: text/html\r\n" +
            "Connection: close\r\n\r\n";

    private final Socket socket;
    private final OutputStream outputStream;
    private final InputStream inputStream;
    private final BufferedReader bufferedReader;
    private final File htmlPage = new File(FILENAME);

    HttpServer(Socket socket) throws Throwable {
        this.socket = socket;
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String[] methodNames = bufferedReader.readLine().split(" ");
            switch (methodNames[0]) {
                case "GET":
                    get(readPage(htmlPage));
                    break;
                case "POST":
                    post();
                    break;
                default:
                    methodNotFound();
                    break;
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        LOGGER.info("Client processing finished");
    }

    public String get(String s) throws Throwable {
        String result = OK + s;
        outputStream.write(result.getBytes());
        outputStream.flush();
        return result;
    }

    public String post() throws Throwable {
        String result = OK + "client answer";
        outputStream.write(result.getBytes());
        outputStream.flush();
        return result;
    }

    public void methodNotFound() throws IOException {
        String result = BADREQUEST + "method not found";
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    private String readPage(File pageFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(pageFile)));
        String content;
        String answer = "";
        while ((content = bufferedReader.readLine()) != null) {
            answer += content;
        }
        return answer;
    }

}