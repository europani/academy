package ch16;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressEx1 {

	public static void main(String[] args) throws IOException {
		InetAddress ip = InetAddress.getByName("www.google.com");
		System.out.println("getByName 메서드 호출");
		System.out.println("hostname : " + ip.getHostName());		// 호스트이름
		System.out.println("hostaddress : " + ip.getHostAddress()); 		// 호스트주소
		InetAddress[] ips = InetAddress.getAllByName("www.google.com");
		
		System.out.println("getAllByName 메서드 호출");
		for (InetAddress i : ips) {
			System.out.println("ip 주소 : " + i);
		}	
		
		System.out.println("getLocalHost 메서드 호출");
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내컴퓨터 : " + local);
	}

}
