package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		String ServerIp = "127.0.0.1";
		int port = 5555;
		Socket client = null;
		String input;
		try {
			client = new Socket(ServerIp, port);
			System.out.println(client.getInetAddress() + ":" + client.getPort() + "서버에 연결되었습니다.");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			
			while ((input = in.readLine())!= null) {
				System.out.println(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
