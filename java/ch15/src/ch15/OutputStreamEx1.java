package ch15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamEx1 {

	public static void main(String[] args) throws IOException {
		
//		OutputStream out = System.out;
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		out.write('1');	out.write('a');	out.write('°¡');
		out.flush();
	} 

}
