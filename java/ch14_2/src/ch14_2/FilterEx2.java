package ch14_2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilterEx2 {

	public static void main(String[] args) throws IOException {
		System.out.println("src/ch14 폴더 목록");
		Path path = Paths.get("src/ch14");
		Stream<Path> st = Files.list(path);
		st.filter(s -> s.getFileName().toString().contains("Ex"))
		.forEach(p -> System.out.println(p.getFileName()));
		
		
	}

}
