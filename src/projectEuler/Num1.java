package projectEuler;

public class Num1 {
	public static void main(String[] args) {
		System.out.println(sumOfMultiples(1000, 3, 5));
	}
	
	public static long sumOfMultiples(long num, long a, long b) {
		long sum = 0;
		for (int i = 1; i <= 1000; i++) {
			long modA = i % a;
			long modB = i % b;
			if (modA==0 || modB==0) {
//				System.out.print(i + " ");
				sum += i; 
			}
		}
		
		return sum;
	}

}
