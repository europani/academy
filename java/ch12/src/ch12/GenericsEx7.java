package ch12;

public class GenericsEx7 {
	public static void main(String[] args) {
		MyArrayList<String> t1 = new MyArrayList<String>();
		t1.add("월매"); 	t1.add("춘향");	t1.add("향단");
		System.out.println(t1.get(2));
		t1.list();
		
		MyArrayList<Integer> t2 = new MyArrayList<Integer>();
		t2.add(1); 	t2.add(2);	t2.add(3);	t2.add(4);	t2.add(5);	t2.add(6);
		System.out.println(t2.get(5));
		t2.list();
	}
	
}

class MyArrayList<T> {
	Object[] v = new Object[3];
	int index = 0;
	
	void add(T t) {
		if (index == v.length) {
			Object[] tmp = new Object[v.length+10];
			System.arraycopy(v, 0, tmp, 0, v.length);
			v = tmp;
		}
		v[index++] = t;
	}
	
	T get(int i) {
		return (T) v[i];
	}
	void list() {
		for (Object s : v) {
			if (s == null) {
				break;
			}
			System.out.print(s + ",");
		}
		System.out.println();
	}
	
}
