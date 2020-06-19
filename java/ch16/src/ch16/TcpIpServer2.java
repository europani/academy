package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer2 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;

	public static void main(String[] args) {
		TcpIpServer2 server = new TcpIpServer2(5);	// 5�� ������ ����
		server.start();
	}
	
	public TcpIpServer2(int num) {
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
			threadArr = new Thread[num];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {	// ������ start()
		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(getTime() + "�� ������ ��ٸ��ϴ�.");
			
			Socket socket;
			try {
				socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�� ������ �Ǿ����ϴ�.");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test message1 from Server");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date())+ name;
	}
}
