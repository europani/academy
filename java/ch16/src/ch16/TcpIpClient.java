package ch16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient {

	public static void main(String[] args) {
		String serverIp = "211.63.89.97";
		
		System.out.println("������ �������Դϴ�. ����IP : " + serverIp);
		Socket socket;
		try {
			socket = new Socket(serverIp, 7777);
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("�����κ��� ���� �޽��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			dis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
