package teamProject;

import java.io.*;
import java.util.*;

enum SortType {
	category, item, idate, itemcode
}
public class TxtToObject {

	static List<Product> li = new ArrayList<Product>();		// Product가 들어가는 List
	static Map<String, List<Product>> map = new HashMap<String, List<Product>>();		// Category별 List를 넣는 Map
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("src/teamProject/productList.txt"));
			while (sc.hasNextLine()) {
				String[] str = sc.nextLine().split(",");
				Product p = new Product(str[0], str[1], str[2], str[3], str[4]);
				li.add(p);
				
				if (!map.containsKey(p.getCategory())) {
					map.put(p.getCategory(), new ArrayList<Product>());	//map에 key가 없으면 새로 만들어라
				}
				map.get(p.getCategory()).add(p);
			}
			print(li);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("============sort getCategory");
		Collections.sort(li, new Comparator<Product>() {
			
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getCategory().compareTo(o2.getCategory());
			}
		});
		/* 람다식
		 * Collections.sort(li, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));
		 */
		print(li);
		
		sort(SortType.category);
		sort(SortType.idate);
		
		
		System.out.println("============도서 category별 list");
		print(map.get("도서"));
		System.out.println("============식료품 category별 list");
		print(map.get("식료품"));
		
	}
	
	static void sort(SortType s) {
		System.out.println("============sort " + s);
		Collections.sort(li, new Comparator<Product>() {
			
			@Override
			public int compare(Product o1, Product o2) {
				switch (s) {
				case category :
					return o1.getCategory().compareTo(o2.getCategory());
				case item :
					return o1.getItem().compareTo(o2.getItem());
				case idate :
					return o1.getIdate().compareTo(o2.getIdate());
				case itemcode :
					return o1.getItemcode().compareTo(o2.getItemcode());
				default :
					return 1;
				}
				
			}
		});
		print(li);
	}
	
	static <T> void print(List<T> li) {
		for (T p : li) {
			System.out.println(p);
		}
	}
		

}
