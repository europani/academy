package ch15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {

	public static void main(String[] args) {
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("test.dat", "rw");
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());	// 0 
			raf.writeInt(100);		// 4byte
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());	// 4 
			raf.writeLong(100L);	// 8byte
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());	// 12
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
