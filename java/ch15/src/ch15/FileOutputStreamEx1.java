package ch15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File("src/ch15/out.txt"));
		fos.write('1');	fos.write('2');	fos.write('3');
		fos.write('a');	fos.write('b');	fos.write('c');
		fos.write('가');	fos.write('나');	fos.write('다');
		System.out.println((int)'1');
		
		byte[] buf = "\n반갑습니다. 이것은 예제입니다.\n".getBytes();
		fos.write(buf);
		fos.write(buf, 13, 2);
		fos.flush();
		

			
	}

}
