package projectEuler;

import java.io.File;
import java.util.Scanner;

public class Num13 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("/Users/sebaek/Documents/digits500.txt"));
		
		long[] result = new long[10];
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int i = 0;
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
			result[i++] += Long.valueOf(line.substring(0, 10 + i));
//			result[i++] += Long.valueOf(line.substring(0, 10 + i));
//			result[i++] += Long.valueOf(line.substring(0, 10 + i));
		}
		scanner.close();
		
		System.out.println(Long.MAX_VALUE);
		
		for (long l : result) {
			System.out.println(l);
		}
		
	}

}
