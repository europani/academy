package teamProject;

import java.io.*;

public class ObjectToTxt {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter(new File("src/teamProject/InputproductList.txt"), true);
			fw.write(new Product("������ǰ", "TV", "20200501", "200", "DT00001").toTxt());
			fw.write(new Product("������ǰ", "��ǻ��", "20200502", "5", "DT00002").toTxt());
			fw.write(new Product("������ǰ", "�ڵ���", "20200503", "1", "DT00003").toTxt());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
