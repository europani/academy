package ch05;

public class ArrayEx5 {

	public static void main(String[] args) {
		System.out.println(args.length);
		if (args.length == 0) {
			System.out.println("cmd���ο� �Ķ���͸� �Է��ϼ���.");
			System.out.println("java ch05.ArrayEx5");
			return;
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("args["+ i + "] = " +args[i]);
		}
	}

}
