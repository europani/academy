package ch16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerEx1 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
			while (true) {
				System.out.println("클라이언트 접속 대기");
				Socket client = server.accept();
				System.out.println("쓰레드 생성");
				HttpThread ht = new HttpThread(client);
				ht.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class HttpThread extends Thread {
		private Socket client;
		BufferedReader br;
		PrintWriter pw;

		HttpThread(Socket client) {
			this.client = client;
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			BufferedReader fbr = null;
			try {
				String line = br.readLine();
				System.out.println("HTTP 헤더 : " + line);
				int start = line.indexOf("/")+1;
				int end = line.indexOf("HTTP")-1;
//				int q = line.indexOf("?");
				String pathname = line.substring(start, end);
//				String query = line.substring(q);
//				System.out.println(query);
				
				if (pathname.equals("")) {
					pathname = "index.html";
				}
				System.out.println("사용자 요청 파일 : " + pathname);
				fbr = new BufferedReader(new FileReader(pathname));
				String fileLine = null;
				pw.println("HTTP/1.0 200 OK\r\nContent-Type: text/html\r\n\r\n");
				
				while ((fileLine = fbr.readLine()) != null) {
					pw.println(fileLine);
					pw.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fbr != null) fbr.close();		
					if (br != null) br.close();
					if (pw != null) pw.close();
					if (client != null) client.close();
				} catch (Exception e2) {
				}
			}
		}
	}

}
