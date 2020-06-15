package ch11;

import java.util.*;

public class MapEx1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] names = {"È«±æµ¿", "±è»ñ°«", "ÀÌ¸ù·æ", "ÀÓ²©Á¤", "±è»ñ°«"};
		int[] nums = {1234,4567,2350,9870,3456};
		for (int i = 0; i < names.length; i++) {
			map.put(names[i], nums[i]);
		}
		System.out.println(map);
		
		System.out.println("È«±æµ¿ÀÇ ¹øÈ£ : " + map.get("È«±æµ¿"));
		System.out.println("±è»ñ°«ÀÇ ¹øÈ£ : " + map.get("±è»ñ°«"));
		System.out.println("ÀÌ¸ù·æÀÇ ¹øÈ£ : " + map.get("ÀÌ¸ù·æ"));
		System.out.println("ÀÓ²©Á¤ÀÇ ¹øÈ£ : " + map.get("ÀÓ²©Á¤"));

		System.out.println("\nKey¸¸ Á¶È¸");
		Set<String> key = map.keySet();
		for (String s : key) {
			System.out.println(s);
		}
		
		System.out.println("\nValues¸¸ Á¶È¸");
		Collection<Integer> values = map.values();
		for (Integer v : values) {
			System.out.println(v);
		}
		
		System.out.println("\n½ÖÀ¸·Î Á¶È¸");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for (Map.Entry<String, Integer> m : entry) {
			System.out.println(m);
		}
				
	}

}
