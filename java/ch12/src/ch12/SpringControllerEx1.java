package ch12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Scanner;

public class SpringControllerEx1 {
	static ControllerClass cc = new ControllerClass();

	public static void main(String[] args) {
		Controller ct = cc.getClass().getAnnotation(Controller.class);
		if (ct!=null) {
			runWeb();
		}
	}

	public static void runWeb() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("url�� �Է��ϼ���  [exit :0]");
			String url = sc.nextLine();
			if (url.equals("0")) {
				break;
			}
			System.out.println("request method ����� �Է��ϼ���.");
			String method = sc.nextLine();
			System.out.println(url + ", " + method);
			runWeb(url, method);
		}
	}

	public static void runWeb(String url, String method) {
		method = method.toUpperCase();
		Method[] methods = cc.getClass().getDeclaredMethods();
		for (Method m : methods) {
			RequestMapping rm = m.getAnnotation(RequestMapping.class);
			if (rm.value().equals(url) && rm.method().name().equals(method)) {
				try {
					m.invoke(cc);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}

@Controller
class ControllerClass {
	
	@RequestMapping("index")
	public void method1() {
		System.out.println("index ����");
	}
	@RequestMapping(value = "main" , method=RequestMethod.GET)
	public void method2() {
		System.out.println("main get ��� ����");
	}
	@RequestMapping(value = "main" , method=RequestMethod.POST)
	public void method3() {
		System.out.println("main post ��� ����");
	}
}


@Retention(RetentionPolicy.RUNTIME)
@interface Controller{}

@Retention(RetentionPolicy.RUNTIME)
@interface RequestMapping{
	String value();
	RequestMethod method() default RequestMethod.GET;
}

enum RequestMethod {
	GET, POST
}