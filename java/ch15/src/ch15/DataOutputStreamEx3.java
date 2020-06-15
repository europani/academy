package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx3 {

	public static void main(String[] args) throws IOException {
		int[] score = {100, 90, 95, 85, 50};
		FileOutputStream fos = new FileOutputStream("score.dat");
		DataOutputStream dos = new DataOutputStream(fos);	
		for (int i = 0; i < score.length; i++) {
			dos.writeInt(score[i]);
		}
		dos.flush();
		dos.close();
	}

}
