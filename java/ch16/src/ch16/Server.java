package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server =null;
		Socket client = null;
		String input;
		try {
			server = new ServerSocket(5555);
			System.out.println("������ ���Ƚ��ϴ�.");
			client = server.accept();
			System.out.println(client.getInetAddress() + ":" + client.getPort() + "Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");
			
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
