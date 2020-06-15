
import java.io.*;
import java.util.*;

enum SortType {
	title, idate, writer, publisher, isbn, category;
}

public class TxtToObject {
	List<Books> list = new ArrayList<Books>();
	Map<String, List<Books>> map = new HashMap<String, List<Books>>();
	Scanner sc = new Scanner(System.in);
	String input;

	public void txtToObject() {
		Scanner scan;
		try {
			scan = new Scanner(new File("src/booksList.txt"));
			while (scan.hasNextLine()) {
				String[] str = scan.nextLine().split(",");
				Books b = new Books(str[0], str[1], str[2], str[3], str[4], str[5], str[6]);
				list.add(b);
				if (!map.containsKey(b.getCategory())) {
					map.put(b.getCategory(), new ArrayList<Books>());
				}
				map.get(b.getCategory()).add(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.printf("      å����\t\t\t  ����\t ����\t ����\t ���ǻ�\t  ������\t\t    isbn\n");
		print(list);
	}

	public void sort(SortType s) {
		System.out.printf("      å����\t\t\t  ����\t ����\t ����\t ���ǻ�\t  ������\t\t    isbn\n");

		Collections.sort(list, 
			(o1, o2) -> {
				switch (s) {
				case title:
					return o1.getTitle().compareTo(o2.getTitle());
				case idate:
					return o1.getIdate().compareTo(o2.getIdate());
				case writer:
					return o1.getWriter().compareTo(o2.getWriter());
				case publisher:
					return o1.getPublisher().compareTo(o2.getPublisher());
				case isbn:
					return o1.getIsbn().compareTo(o2.getIsbn());
				case category:
					return o1.getCategory().compareTo(o2.getCategory());
				default:
					return o1.getCategory().compareTo(o2.getCategory());
				}
		});
		print(list);
	}

	static <T> void print(List<T> list) {
		for (T p : list) {
			System.out.println(p);
		}
	}
	
	void printSort(String select) {
		switch (select) {
		case "All":
			print(list);
			break;
		case "Title":
			System.out.println("å������ �Է����ּ���.");
			input = sc.nextLine();
			list.stream().filter(b -> b.getTitle().contains(input)).forEach(System.out::println);
			
//			Iterator<Books> it = list.iterator();
//			while (it.hasNext()) {
//				Books b = it.next();
//				if (b.getTitle().contains(input)) {
//					System.out.println(b);
//				}
//			}
			break;
		case "Category":
			System.out.println("ī�װ��� �Է����ּ���.");
			System.out.println("[����, ����, �ι�, ����, ��ȸ, ������, �ڱ���, ����, �ڿ�����]");
			input = sc.nextLine();
			List<Books> li = map.get(input);
			for (Books b : li) {
				System.out.println(b);
			}
			break;
		}
	}
}
