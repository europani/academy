package ch15;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStreamEx2 {

	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		byte[] result = null;
		
		dos.writeInt(10);		// 4byte
		dos.writeFloat(20.0f);	// 4byte
		dos.writeBoolean(true);	// 1byte
		result = bos.toByteArray();
		System.out.println("10���� : " + Arrays.toString(result));
		dos.close();
	}

}
