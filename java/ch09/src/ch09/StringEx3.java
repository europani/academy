package ch09;

public class StringEx3 {

	public static void main(String[] args) {
		String s = "HTML-CSS-JavaScript-Java-JSP-Spring";
		String[] subject = s.split("-");
		for (int i = 0; i < subject.length; i++) {
			System.out.println((i+1)+ ":" + subject[i]);
		}
		
		s = "ȫ�浿,���,�̸���,������,�Ӳ���";
		String[] name = s.split(",");
		for (String n : name) {
			System.out.println(n);
		}
		System.out.println("��ü �ο� : " + name.length + "��" );
		
		int i = Integer.parseInt("100");
		double d = Double.parseDouble("100.5");
		System.out.println(i+1);
		System.out.println(d+0.1);
		
		String sf = String.format("%.2f", d+0.125);	System.out.println(sf);
		sf = String.format("%10d", i);	System.out.println(sf);
		sf = String.format("%X", i);	System.out.println(sf);
		sf = String.format("%o", i);	System.out.println(sf);
				
	}

}
