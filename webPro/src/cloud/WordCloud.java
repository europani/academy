package cloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordCloud {
	public static Map<String, Long> map(String url, String selector, int num) {
		Document doc = null;
		String output = "";
		List<String> list = new ArrayList<String>();
		Map<String, Long> map = null;
		int count = 0;
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Elements titles = doc.select(selector);
		for (Element e : titles) {
			String line = e.text();
			System.out.println(line);
			
			line = line.replace(",,", ",");
			line = line.replace("\"", " ");
			line = line.replace("1", " ");
			line = line.replace("2", " ");
			line = line.replace("3", " ");
			line = line.replace("4", " ");
			line = line.replace("5", " ");
			line = line.replace("6", " ");
			line = line.replace("7", " ");
			line = line.replace("8", " ");
			line = line.replace("9", " ");
			line = line.replace("0", " ");
			line = line.replace("%", " ");
			line = line.replace('"', ' ');
			line = line.replace('\'', ' ');
			line = line.replace('[', ' ');
			line = line.replace(']', ' ');
			line = line.replace('/', ' ');
			line = line.replace('\n', ' ');
			line = line.replace("±â»ç", "");
			line = line.replace("NEW", "");
			String[] strs = line.split(" ");
			list.addAll(Arrays.asList(strs));
		}
			
			// word count
			map = list.stream().filter(s -> !s.equals(""))
					.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
			// value count
			Map<String, Long> map2 = map.entrySet().stream().sorted(new Comparator<Map.Entry>() {
				public int compare(Entry o1,Entry o2) {
					long num1 = 0;
					long num2 = 0;
					try {
						num1 = (long) (o1.getValue());
						num1 = (long) (o2.getValue());
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						return (int) (num2 - num1);
					}
					
				};
				
			}).collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
		return map2;
	}
}
