package ch16;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressEx1 {

	public static void main(String[] args) throws IOException {
		InetAddress ip = InetAddress.getByName("www.google.com");
		System.out.println("getByName �޼��� ȣ��");
		System.out.println("hostname : " + ip.getHostName());		// ȣ��Ʈ�̸�
		System.out.println("hostaddress : " + ip.getHostAddress()); 		// ȣ��Ʈ�ּ�
		InetAddress[] ips = InetAddress.getAllByName("www.google.com");
		
		System.out.println("getAllByName �޼��� ȣ��");
		for (InetAddress i : ips) {
			System.out.println("ip �ּ� : " + i);
		}	
		
		System.out.println("getLocalHost �޼��� ȣ��");
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("����ǻ�� : " + local);
	}

}
