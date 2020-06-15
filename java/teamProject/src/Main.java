import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] list = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		int cnt = 0;

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		for (int i = 0; i < input.length()-1; i++) {
			String sub = input.substring(i, i+2);
			for (int j = 0; j < list.length; j++) {
				if (sub.contains(list[j])) {
					cnt++;
				}
			}
		}
		System.out.println(input.length() - cnt);
	}

}
