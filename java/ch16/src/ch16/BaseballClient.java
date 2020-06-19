package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BaseballClient {

	public static void main(String[] args) {
		int port = 5000;
		String ip = "127.0.0.1";
		
		Socket client = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			String input;
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			client = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			System.out.println("local port : " + client.getLocalPort());
			System.out.println("local ip : " + client.getLocalAddress());
			System.out.println("server port : " + client.getPort());
			System.out.println("server ip : " + client.getInetAddress());

			System.out.print(">> ");
			while ((input = stdin.readLine()) != null) {
				if (input.equals("bye")) break;
				out.println(input);
				out.flush();
				System.out.println(in.readLine());
				System.out.print(">>");
			}
				out.close();
				in.close();
				stdin.close();
				client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
