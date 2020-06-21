package teamProject3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Server {
	List<Books> list = new ArrayList<Books>();
	Map<String, List<Books>> map = new HashMap<String, List<Books>>();

	Server() {
		Scanner scan;
		try {
			scan = new Scanner(new File("src/teamProject3/booksList.txt"));
			while (scan.hasNextLine()) {
				String[] str = scan.nextLine().split(",");
				Books b = new Books(str[0], str[1], str[2], str[3], str[4], str[5], str[6]);
				list.add(b);
				if (!map.containsKey(b.getCategory())) {
					map.put(b.getCategory(), new ArrayList<Books>());
				}
				map.get(b.getCategory()).add(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Server s = new Server();
		try {
			ServerSocket server = new ServerSocket(1234);
			while (true) {
				System.out.println("클라이언트 연결 대기중");
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " 클라이언트가 연결되었습니다.");
				new ServerThread(socket, s.list, s.map).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class ServerThread extends Thread {
	Socket socket;
	PrintWriter out;
	BufferedReader in;

	List<Books> list;
	Map<String, List<Books>> map;
	List<Books> wishList = new ArrayList<Books>();
	Member m;
	String option;
	String id;
	String password;

	ServerThread(Socket socket, List<Books> list, Map<String, List<Books>> map) {
		this.socket = socket;
		this.list = list;
		this.map = map;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			m = new Member(out, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String input;
		try {
			while ((input = in.readLine()) != null) {
				System.out.println("입력 : " + input);
				String menu = input.substring(0, input.indexOf(" "));
				if (input.contains(";")) {
					option = input.substring(input.indexOf(";") + 1);
				}
				sendClient(menu);

			} // while
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendClient(String menu) throws IOException {
		if (menu.contains("check")) {				// 1
			if (menu.contains("All")) {				// 1_1
			} else if (menu.contains("Category")) {	// 1_2
				sort("category");
			} else if (menu.contains("Date")) {		// 1_3
				sort("idate");
			}
			out.println(printString(list));
		} else if (menu.contains("buy")) {			// 2
			if (menu.contains("All")) {				// 2_1
				out.println(printString(list));
			} else if (menu.contains("Title")) {	// 2_2
				printSort("Title");
			} else if (menu.contains("Category")) {	// 2_3
				printSort("Category");
			}
			makeWishList();
		} else if (menu.equals("history")) {		// 3
			printWishlist();
		} else if (menu.equals("signUp")) {			// 4
			id = option.substring(0, option.indexOf(" "));
			password = option.substring(option.indexOf(" ") + 1);
			m.signUp(id, password);	
		} else if (menu.equals("login")) {			// 5
			id = option.substring(0, option.indexOf(" "));
			password = option.substring(option.indexOf(" ") + 1);
			m.login(id, password);
		}
	}

	public void sort(String s) {
		Collections.sort(list, (o1, o2) -> {
			switch (s) {
			case "title":
				return o1.getTitle().compareTo(o2.getTitle());
			case "idate":
				return o1.getIdate().compareTo(o2.getIdate());
			case "writer":
				return o1.getWriter().compareTo(o2.getWriter());
			case "publisher":
				return o1.getPublisher().compareTo(o2.getPublisher());
			case "isbn":
				return o1.getIsbn().compareTo(o2.getIsbn());
			case "category":
				return o1.getCategory().compareTo(o2.getCategory());
			default:
				return o1.getCategory().compareTo(o2.getCategory());
			}
		});
	}

	void printSort(String select) throws IOException {
		String input;
		List<Books> li = null;
		switch (select) {
		case "Title":
			li = list.stream().filter(b -> b.getTitle().contains(option)).collect(Collectors.toList());
			out.println(printString(li));
			break;
		case "Category":
			li = map.get(option);
			out.println(printString(li));
			break;
		}
	}

	void makeWishList() throws IOException {
		String input = in.readLine();

		Iterator<Books> it = list.iterator();
		while (it.hasNext()) {
			Books b = it.next();
			if (input.equals(b.getTitle())) {
				wishList.add(b);
				out.println("구매리스트에 추가 되었습니다.");

				Date today = new Date();
				FileWriter fw = new FileWriter(new File("src/teamProject3/wishList.txt"), true);
				fw.write(b.toTxt(today));
				fw.close();
			}
		}
		if (wishList.isEmpty() == true) {
			out.println("재고가 부족합니다.");
		}

	}

	String printString(List<Books> a) {
		String s = "      책제목\t\t\t  주제\t 가격\t 저자\t 출판사\t  발행일\t\t    isbn;";
		for (Books p : a) {
			s += p.toString();
		}
		return s;
	}

	void printWishlist() {
		long cnt = wishList.stream().count();
		long sum = wishList.stream().mapToLong(b -> b.getPrice()).sum();

		String s = "===========================구매리스트===========================;";
		for (Books p : wishList) {
			s += p.toString();
		}
		s += "==============================================================;";
		s += "총 갯수 : " + cnt + ";";
		s += "총 금액 : " + sum + ";";
		out.println(s);
	}

}
