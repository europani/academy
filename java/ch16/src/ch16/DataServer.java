package ch16;

// 멀티 echo서버 -> 여러개의 클라이언트와 통신

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataServer {
	List<Product> li = new ArrayList<Product>();
	Map<String, List<Product>> map = new HashMap<String, List<Product>>();

	public static void main(String[] args) {
		DataServer fileserver = new DataServer();
		try {
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				System.out.println("클라이언트 접속 대기중");
				Socket client = server.accept();
				System.out.println("클라이언트가 연결 되었습니다.");
				new EchoServerThread(client, fileserver.li, fileserver.map).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	DataServer() {		// txt -> Object
		try {
			Scanner sc2 = new Scanner(new File("src/ch16/productList.txt"));
			while (sc2.hasNextLine()) {
				String[] str = sc2.nextLine().split(",");
				Product p = new Product(str[0], str[1], str[2], str[3], str[4]);
				li.add(p);
				if (!map.containsKey(p.getCategory())) {
					map.put(p.getCategory(), new ArrayList<Product>());
				}
				map.get(p.getCategory()).add(p);
			}
			System.out.println(li);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class EchoServerThread extends Thread { // 쓰레드
	Socket client;
	PrintWriter out;
	BufferedReader in;
	List<Product> li;
	Map<String, List<Product>> map;

	EchoServerThread(Socket client, List<Product> li, Map<String, List<Product>> map) {
		this.client = client;
		try {
			out = new PrintWriter(client.getOutputStream());
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			this.li = li;
			this.map = map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("client ip : " + client.getInetAddress() + ":" + client.getPort());
	}

	public void sendClient(String input) {	//input of Client -> Server -> 가공 후 sent to Client 
		String menu = input.substring(0, input.indexOf(":"));
		String msg = input.substring(input.indexOf(":"));
		System.out.println(menu);
		switch (menu) {
		case "menu1":
			out.print("회원가입이 완료되었습니다." + msg);
			break;
		case "menu2":
			out.print("로그인이 되었습니다." + msg);
			break;
		case "menu31":
			out.println(printString());
			break;
		default:
			break;
		}
		out.flush();
	}

	String printString() {
		String s = "";
		for (Product p : li) {
			s+= p.toTxt();
		}
		return s;
	}
	
	String printString(String name) {
		String s = "";
		for (Product p : li) {
			if (p.toTxt().contains(name)) {
				s+= p.toTxt();
			}
		}
		return s;
	}
	
	@Override
	public void run() {
		String input = "";
		try {
			while ((input = in.readLine()) != null) {
				System.out.println("client msg : " + input);
				sendClient(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
