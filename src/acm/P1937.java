package acm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1937 {
	private static Scanner scanner;
	private static List<List<Integer>> matrix;
	public static void set() {
//		scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("input1937-1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		matrix = new ArrayList<>();
		
		int size = scanner.nextInt();
		
		List<Integer> dummy = new ArrayList<>();
		for (int i = 0; i < size+2; i++) {
			dummy.add(Integer.MIN_VALUE);
		}
		matrix.add(dummy);
		for (int i = 0; i < size; i++) {
			List<Integer> row = new ArrayList<>();
			row.add(Integer.MIN_VALUE);
			for (int j = 0; j < size; j++) {
				row.add(scanner.nextInt());
			}
			row.add(Integer.MIN_VALUE);
			matrix.add(row);
		}
		matrix.add(dummy);
		
	}
	
	public static void close() {
		
		if (scanner != null) scanner.close();
		
	}
	
	public static void main(String[] args) {
		set();
		
//		for (List<Integer> row : matrix) {
//			for (Integer integer : row) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();
//		}
		
		int result = solution();
		
		System.out.println(result);
		
		close();
	}

	private static int solution() {
		int result = 0;
		
		for (int x = 1; x <= matrix.size()-2; x++) {
			for (int y = 1; y <= matrix.size()-2; y++) {
					result = Math.max(result, solution(x,y));
				}
		}
		
		return result;
	}

	private static int solution(int x, int y) {
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;
		
		if (matrix.get(x-1).get(y) > matrix.get(x).get(y)) {
			up = solution(x-1, y);
		}
		
		if (matrix.get(x+1).get(y) > matrix.get(x).get(y)) {
			down = solution(x+1, y);
		}
		
		if (matrix.get(x).get(y-1) > matrix.get(x).get(y)) {
			left = solution(x, y-1);
		}
		
		if (matrix.get(x).get(y+1) > matrix.get(x).get(y)) {
			right = solution(x, y+1);
		}
		
		return 1 + Math.max(Math.max(up, down), Math.max(left, right));
		
	}
}
