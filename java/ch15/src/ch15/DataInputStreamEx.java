package ch15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx {

	public static void main(String[] args) {
		int sum = 0, score = 0;

		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			while (true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
		} catch (EOFException e) {
			System.out.println("Á¡¼öÀÇ ÃÑÇÕ : " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
