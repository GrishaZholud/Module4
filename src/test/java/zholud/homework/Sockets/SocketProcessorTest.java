package zholud.homework.Sockets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.net.Socket;
import static org.assertj.core.api.Assertions.assertThat;


class SocketProcessorTest {

    private final Socket socket = new Socket("localhost",8080);

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    private final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    private String[] responseArr;

    private static HttpServerStarter serverStarter;

    private final static String GET = "GET / HTTP/1.1\r\n";
    private final static String POST = "POST / HTTP/1.1\r\n";

    SocketProcessorTest() throws Throwable {
    }

    @BeforeAll
    static void run() {
        serverStarter = new HttpServerStarter();
        new Thread(serverStarter).start();
    }


    @Test
    void get() throws Throwable {
        send(GET);
        parse();
        assertThat(responseArr[1]).isEqualTo("200");
    }

    @Test
    void post() throws IOException {
        send(POST);
        parse();
        assertThat(responseArr[1]).isEqualTo("200");
    }

    private String[] parse() throws IOException {
        String response = bufferedReader.readLine();
        responseArr = response.split(" ");
        return responseArr;
    }

    private void send(String out) throws IOException {
        bufferedWriter.write(out);
        bufferedWriter.flush();
    }
}