package ch16;

import java.io.IOException;
import java.net.Socket;

public class TcpIpClient3 {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		int port = 7777;
		
		try {
			Socket socket = new Socket(serverIp, port);
			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
