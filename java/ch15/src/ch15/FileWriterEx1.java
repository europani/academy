package ch15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx1 {

	public static void main(String[] args) throws IOException {
		FileWriter fos = new FileWriter(new File("src/ch15/out2.txt"));
		fos.write('1');	fos.write('2');	fos.write('3');
		fos.write('a');	fos.write('b');	fos.write('c');
		fos.write('가');	fos.write('나');	fos.write('다');
		
		char[] buf = "\n반갑습니다. 이것은 예제입니다.\n".toCharArray();
		fos.write(buf);
		fos.write(buf, 13, 2);
		System.out.println((int)'\n');	// 10
		fos.write('\n'); 	fos.write("안녕.");
//		fos.write(10)
		fos.flush();
		

	}

}
