package ch11;

import java.util.*;

public class IteratorEx2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("³ªÀÚ¹Ù", 85);
		map.put("È«±æµ¿", 90);
		map.put("µ¿Àå±º", 80);
		map.put("È«±æµ¿", 95);	// ¼öÁ¤
		System.out.println("ÃÑ Entry ¼ö : " + map.size());
		System.out.println("È«±æµ¿ : " + map.get("È«±æµ¿"));
		System.out.println();
		
		// keySet()
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		// »èÁ¦
		map.remove("È«±æµ¿");		
		System.out.println("ÃÑ Entry ¼ö : " + map.size());
		
		// entrySet()
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		// values()
		Collection<Integer> c = map.values();
		Iterator<Integer> valueIterator = c.iterator();
		while (valueIterator.hasNext()) {
			Integer value = valueIterator.next();
			System.out.println(value);
		}
		System.out.println();
		
		//ÀüÃ¼ »èÁ¦
		map.clear();
		System.out.println("ÃÑ Entry ¼ö : " + map.size());
	}

}
