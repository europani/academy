package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FileEx4 {

	public static void main(String[] args) {
		if (args.length != 1 || args[0].length() != 1 || "tTLlnN".indexOf(args[0]) == -1) {
			System.out.println("USAGE : java FileEx4 SORT_OPTION    ");
			System.out.println("    SORT_OPTION :                   ");
			System.out.println("    t  Time ascending sort.         ");
			System.out.println("    T  Time descending sort.        ");
			System.out.println("    l  Length ascending sort.       ");
			System.out.println("    L  Length descending sort.      ");
			System.out.println("    n  Name ascending sort.         ");
			System.out.println("    N  Name descending sort.        ");
			System.exit(0);
		}
		
		final char option = args[0].charAt(0);
		
		String currDir = System.getProperty("user.dir");
		File dir = new File(currDir);
		File[] files = dir.listFiles();
		
		Comparator comp = (o1, o2) -> {
			long time1 = ((File) o1).lastModified();
			long time2 = ((File) o2).lastModified();
			long length1 = ((File) o1).length();
			long length2 = ((File) o2).length();
			String name1 = ((File) o1).getName().toLowerCase();
			String name2 = ((File) o2).getName().toLowerCase();
			
			long result = 0;
			
			switch (option) {
			case 't': result = time1 - time2; break;
			case 'T': result = time2 - time1; break;
			case 'l': result = length1 - length2; break;
			case 'L': result = length2 - length1; break;
			case 'n': result = name1.compareTo(name2); break;
			case 'N': result = name2.compareTo(name1); break;
			}
			int re = 0;
			if (result > 0) re = 1;
			else if (result <0) re = -1;
			return re;
		};
		
		Arrays.sort(files);
		Arrays.sort(files, comp);
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			String attribute = "";
			String size = "";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MMa");
			if (files[i].isDirectory()) {
				attribute = "DIR";
			} else {
				size = f.length() + "";
				attribute += (f.canRead())? "R" : "";
				attribute += (f.canWrite())? "W" : "";
				attribute += (f.isHidden())? "H" : "";
			}
			System.out.printf("%s %3s %6s %s%n", df.format(new Date(f.lastModified())), attribute, size, name);
		}
	}

}
