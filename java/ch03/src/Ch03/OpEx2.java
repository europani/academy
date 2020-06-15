package Ch03;

public class OpEx2 {

	public static void main(String[] args) {
		int x=5,y=0;
		y = x++;
		System.out.println("x=" + x + ", y=" + y); 	//x=6, y=5
		
		y = ++x;
		System.out.println("x=" + x + ", y=" + y);	//x=7, y=7
		System.out.println("x=" + x++);				//x=7 Ãâ·Â ÈÄ x=8
		System.out.println("x=" + ++x);				//x=9
		
		x = y--;
		System.out.println("x=" + x + ", y=" + y);	//x=7, y=6
		x = --y;
		System.out.println("x=" + x + ", y=" + y);	//x=5, y=5

	}

}
