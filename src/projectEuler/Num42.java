package projectEuler;

import java.io.FileInputStream;
import java.util.Scanner;

public class Num42 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new FileInputStream("/Users/sebaek/Downloads/p042_words.txt"));
		scanner.useDelimiter("[\",]+");
		
		long result = getResult(scanner);
		
		System.out.println(result);
		scanner.close();
	}
	
	
	public static long getResult(Scanner scanner) {
		long result = 0;
		while (scanner.hasNext()) {
			if (isTriangleWord(scanner.next())) {
				result++;
			}
		}
		
		return result;
	}
	
	
	
	public static boolean isTriangleWord(String word) {
		long sumOfCode = 0;
		for (char c : word.toCharArray()) {
			sumOfCode += (c - 'A' + 1);
		}
		
		return isTrianlgeNumber(sumOfCode);
	}


	private static boolean isTrianlgeNumber(double sumOfCode) {
		double sqrt = Math.sqrt(sumOfCode * 2);
		sqrt = Math.floor(sqrt);
		if (sqrt * (sqrt+1) == sumOfCode * 2) {
			return true;
		}
		
		
		return false;
	}
}
