package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write("Hello, dear friend.".getBytes());
                    String str = in.readLine();
                    if (str.contains("msg=Exit")) {
                        out.write("\r\nServer is closed.".getBytes());
                        server.close();
                    } else if (str.contains("msg=Hello")) {
                        out.write("\r\nHello".getBytes());
                    } else {
                        out.write(("\r\nWhat".getBytes()));
                    }
                    out.flush();
                }
            }
        }
    }
}
