package acm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class P10989 {
	private static Scanner scanner;
	private static List<Integer> list;
	public static void set() {
//		scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("input10989.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		list = new ArrayList<>();
	}
	
	public static void close() {
		
		if (scanner != null) scanner.close();
		
	}
	
	public static void main(String[] args) {
		set();
		
		int count = scanner.nextInt();
		
		for (int i = 0; i < count; i++) {
			addNumber(scanner.nextInt());
		}
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		close();
	}

	private static void addNumber(int element) {
		int start = 0;
		int end = list.size() - 1;
		int targetIndex = (end - start) / 2 + start;
		
		while(start <= end) {
			if (list.get(targetIndex) > element) {
				end = targetIndex - 1;
				targetIndex = (end - start) / 2 + start;
			} else {
				start = targetIndex + 1;
				targetIndex = (end - start) / 2 + start;
			}
		}
		
		list.add(targetIndex, element);
	}
}
