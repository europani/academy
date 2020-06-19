package ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultichatClient {

	public static void main(String[] args) {
		String name = "저요";
		String serverIp = "211.63.89.96";
		try {
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new ClientSender(socket, name);
			Thread receiver = new ClientReciever(socket);
			
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class ClientSender extends Thread {
		Socket socket;
		String name;
		DataOutputStream out;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			if (out != null) {
				try {
					out.writeUTF(name);
					while (out != null) {
						out.writeUTF("[" + name + "]" + sc.nextLine());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class ClientReciever extends Thread {
		Socket socket;
		DataInputStream in;

		public ClientReciever(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while (in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
