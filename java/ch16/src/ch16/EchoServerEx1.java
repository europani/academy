package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerEx1 {

	public static void main(String[] args) {
		int port = 5000;
		Socket client = null;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("Server 준비됨");
			client = server.accept();
			System.out.println("server : " + server);
			System.out.println("localport : " + client.getLocalPort());
			System.out.println();
			System.out.println("connected ip : " + client.getInetAddress());
			System.out.println("connected port : " + client.getPort());
			
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String input;
			while ((input = in.readLine())!= null) {
				out.println(input);		// Echo -> input 내용을 바로 다시 output
				out.flush();
				System.out.println("to client : " + input);
			}
			in.close();
			out.close();
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
