package ch14_2;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileToStreamEx {

	public static void main(String[] args) throws IOException {
		System.out.println("파일의 내용을 스트림을 이용하여 화면에 출력");
		BufferedReader br = new BufferedReader(new FileReader(new File("src/ch14/FiletoStream.txt")));
		br.lines().forEach(s -> System.out.println(s));
		System.out.println();
		
		System.out.println("src/ch14/ 폴더 목록");
		Path path = Paths.get("src/ch14");
		Stream<Path> st = Files.list(path);
		st.forEach(p -> System.out.println(p.getFileName()));
		System.out.println();
		
		System.out.println("C:/temp 폴더 목록");
		path = Paths.get("C:/temp");
		Stream<Path> stream = Files.list(path);
		stream.forEach(p -> System.out.println(p.getFileName()));
		
		
		
		
	}

}
