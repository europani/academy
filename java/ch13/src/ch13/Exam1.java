package ch13;

import java.util.*;
import java.util.Scanner;

public class Exam1 {
	List<String> words = new ArrayList<String>();
	String[] data = {"태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카 "};
	int interval = 3*1000;

	public static void main(String[] args) {
		Exam1 g = new Exam1();
		g.game();
		System.out.println("프로그램 종료");
	}
	
	void game() {
		Scanner sc = new Scanner(System.in);
		words.add(data[0]);
		DataAddThread t1 = new DataAddThread(words, data, interval);
		t1.setDaemon(true);
		t1.start();
		while (true) {
			System.out.println(words);
			System.out.print(">>");
			String input = sc.next().trim();
			words.remove(input);
			if (words.size() == 0) {
				break;
			}
		}
	}

}

class DataAddThread extends Thread {
	List<String> words;
	String[] data;
	int interval;
	
	DataAddThread(List<String> words, String[] data, int interval) {
		this.words = words;
		this.data = data;
		this.interval = interval;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				sleep(interval);
			} catch (InterruptedException e) {}
			words.add(data[(int) (Math.random()*data.length)]);
		}
	}
	
}
