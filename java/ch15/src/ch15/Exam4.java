package ch15;

import java.io.File;

public class Exam4 {

	public static void main(String[] args) {
		File f1 = new File("c:/windows");
		int cnt[] = new int[2];
		String files[] = f1.list();
		long size = 0;
		for (String f : files) {
			File f2 = new File(f1, f);
			if (f2.isDirectory()) {
				cnt[0]++;
			}
			if (f2.isFile()) {
				cnt[1]++;
				size += f2.length();
			}
		}
		System.out.println("폴더의 갯수 : " + cnt[0]);
		System.out.println("파일의 갯수 : " + cnt[1]);
		System.out.printf("파일의 총 크기 : %,dbyte", size);
				
	}

}
