package ch15;

import java.io.*;

public class BufferedReaderEx1 {

	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		FileWriter fw = new FileWriter("src/ch15/buffered.txt");
		
		String data = null;
		while ((data = br.readLine()) != null) {
			System.out.println(data);
			fw.write(data + "\n");
		}
		fw.flush();
		fw.close();
	}

}
