package teamProject;
import java.util.Scanner;

/*
	18 by 18
	반시계 방향 회전 1, 시계 방향 회전2, 블럭 떨어뜨리기 3, 종료 4:>
	값을 랜덤하게 채움.
*/

public class InputNum4 {
	
	public static void main(String[] args) {
		final int WIDTH = 18;
		final int HEIGHT = 18;
		String[][] str = new String[WIDTH][HEIGHT];

		for (int i = 0; i < str.length; i++) {
			int random = (int) (Math.random() * 16 + 1);
			for (int j = 0; j < str[i].length; j++) {
				if (i == 0 || j == 0 || i == str.length - 1 || j == str[i].length - 1) {
					str[i][j] = String.format("%2s", "@");
				} else if (j <= random) {
					str[i][j] = String.format("%2s", "2");
				} else {
					str[i][j] = String.format("%2s", " ");
				}
				System.out.print(str[i][j]);
			}
			System.out.println();
		}
		outer: while (true) {
			String[][] result = new String[WIDTH][HEIGHT];
			System.out.print("반시계 방향 회전 1, 시계 방향 회전2, 블럭 떨어뜨리기 3, 종료 4:>");
			Scanner sc = new Scanner(System.in);
			int ans = sc.nextInt();
			if (ans > 4 || ans < 1) {
				System.out.println("값을 다시 입력해주세요.");
				continue;
			}

			switch (ans) {
			case 1:		// 반시계
				for (int i = 0; i < result.length; i++) {
					for (int j = 0; j < result.length; j++) {
							result[i][j] = str[j][result.length - i - 1];	// (1, 1) <= (1, 16)
							System.out.print(result[i][j]);
					} System.out.println();
				}
				str = result;

				break;

			case 2:		// 시계
				for (int i = 0; i < result.length; i++) {
					for (int j = 0; j < result.length; j++) {
						result[i][j] = str[result.length - j - 1][i];		// (1, 1) <= (16, 1)
							System.out.print(result[i][j]);                                     
					} System.out.println();
				}
				str = result;

				break;
			case 3:
				int[] cntArr = new int[WIDTH];
				for (int j = 0; j < str.length - 1; j++) {		// 카운트 배열
					int cnt = 0;
					for (int i = 0; i < str.length - 1; i++) {
						if (str[i][j].charAt(1) == '2') {
							cnt++;
						}
					}
					cntArr[j] = cnt;
				}

				for (int j = 0; j < result.length; j++) {		// 좌측 하단부터 채우기
					for (int i = str.length - 1; i >= 0; i--) {
						if (i == 0 || j == 0 || i == result.length - 1 || j == result[i].length - 1) {
							result[i][j] = String.format("%2s", "@");
						} else if (i >= 17 - cntArr[j]) {
							result[i][j] = String.format("%2s", "2");
						} else {
							result[i][j] = String.format("%2s", " ");
						}
					}
				}

				for (int i = 0; i < result.length; i++) {		// 행렬 출력
					for (int j = 0; j < result.length; j++) {
						System.out.print(result[i][j]);
					}
					System.out.println();
				}
				str = result;
				
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break outer;
			}
		}
	}
}
