package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BaseballServer {
	static int[] answer = new int[4];
	static String input;

	public static void main(String[] args) {
		makeAnswer();
		
		// 네트워크
		int port = 5000;
		Socket client = null;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("Server 준비됨");
			client = server.accept();
			System.out.println("server : " + server);
			System.out.println("localport : " + client.getLocalPort());
			System.out.println();
			System.out.println("connected ip : " + client.getInetAddress());
			System.out.println("connected port : " + client.getPort());

			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while ((input = in.readLine()) != null) {
				System.out.println(input);
				out.println(rightOrWrong(input));
				out.flush();
			}
			in.close();
			out.close();
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void makeAnswer() {
		int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};		// 숫자후보
		
		Scanner sc = new Scanner(System.in);
		// 셔플
		for (int i = 0; i < 1000; i++) {
			int a = (int) (Math.random()*num.length);
			int b = (int) (Math.random()*num.length);
			int tmp = num[a];
			num[a] = num[b];
			num[b] = tmp;
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = num[i];
		}
	}
	
	public static String rightOrWrong(String input) {
		boolean right = false;
		int strike = 0, ball = 0;
		int[] inputArr = new int[4];
		for (int i = 0; i < input.length(); i++) {
			inputArr[i] = input.charAt(i) - '0';
		}
		
		for (int i = 0; i < inputArr.length; i++) {
			for (int j = 0; j < inputArr.length; j++) {
				if (inputArr[j] == answer[i]) {
					if (i==j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
		if (strike == 4) {
			right = true;
			return "홈런! 정답입니다.";
		}
		else {
		return "strike : " + strike + ", ball : " + ball;
		}
		
	}

}
