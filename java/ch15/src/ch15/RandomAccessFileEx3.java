package ch15;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx3 {

	public static void main(String[] args) {
		int sumkor = 0, sumeng = 0, summath = 0;
		int i = 4;
		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
			while (true) {
				raf.seek(i);
				sumkor += raf.readInt();	// pointer : +4
				sumeng += raf.readInt();	// pointer : +4
				summath += raf.readInt();	// pointer : +4
				i += 16;
			}
		} catch (EOFException e) {
			System.out.println("sumkor : " + sumkor);	
			System.out.println("sumeng : " + sumeng);
			System.out.println("summath : " + summath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
