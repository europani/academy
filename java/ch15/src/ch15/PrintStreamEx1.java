package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

// 보조스트림 : PrintStream

public class PrintStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("src/ch15/print.txt");
		PrintStream ps = new PrintStream(fos, true);		// autoFlush : true
		ps.println("홍길동"); ps.println(123);	ps.println(true);
		ps.write(65);
//		ps.flush();
		
		ps = new PrintStream("src/ch15/print2.txt");
		ps.println("홍길동"); ps.println(123);	ps.println(true);
		ps.write(65);
		ps.flush();
	}

}
