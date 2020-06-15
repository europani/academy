package ch15;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileEx2 {

	public static void main(String[] args) throws IOException {
		File f1 = new File("c:/temp1");		// ���� ����. ���� ����
		System.out.printf("%s ���� ���� : %b%n", f1.getAbsolutePath(), f1.mkdir());
		File f2 = new File("c:/temp1/text.txt");	// ���� ����
		System.out.printf("%s ���� ���� : %b%n", f2.getAbsolutePath(), f2.createNewFile());
		File f3 = new File("c:/temp1/text2.txt");	// ���� ����
		System.out.printf("%s -> %s ���� �̸����� : %b%n", f2.getName(), f3.getName(), f2.renameTo(f3));
		System.out.printf("%s ���� ���� ���� �ð� : %s%n", f3.getName(), new Date(f3.lastModified())); 
		System.out.printf("%s ���� ���� : %b%n", f3.getName(), f3.delete());
	}

}
