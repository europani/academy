package ch15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File("src/ch15/out.txt"));
		fos.write('1');	fos.write('2');	fos.write('3');
		fos.write('a');	fos.write('b');	fos.write('c');
		fos.write('��');	fos.write('��');	fos.write('��');
		System.out.println((int)'1');
		
		byte[] buf = "\n�ݰ����ϴ�. �̰��� �����Դϴ�.\n".getBytes();
		fos.write(buf);
		fos.write(buf, 13, 2);
		fos.flush();
		

			
	}

}
