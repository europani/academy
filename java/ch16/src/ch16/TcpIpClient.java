package ch16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient {

	public static void main(String[] args) {
		String serverIp = "211.63.89.97";
		
		System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
		Socket socket;
		try {
			socket = new Socket(serverIp, 7777);
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
			dis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
