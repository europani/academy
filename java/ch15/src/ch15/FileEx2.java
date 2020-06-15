package ch15;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileEx2 {

	public static void main(String[] args) throws IOException {
		File f1 = new File("c:/temp1");		// 폴더 지정. 없는 폴더
		System.out.printf("%s 폴더 생성 : %b%n", f1.getAbsolutePath(), f1.mkdir());
		File f2 = new File("c:/temp1/text.txt");	// 없는 파일
		System.out.printf("%s 파일 생성 : %b%n", f2.getAbsolutePath(), f2.createNewFile());
		File f3 = new File("c:/temp1/text2.txt");	// 없는 파일
		System.out.printf("%s -> %s 파일 이름변경 : %b%n", f2.getName(), f3.getName(), f2.renameTo(f3));
		System.out.printf("%s 파일 최종 수정 시간 : %s%n", f3.getName(), new Date(f3.lastModified())); 
		System.out.printf("%s 파일 삭제 : %b%n", f3.getName(), f3.delete());
	}

}
