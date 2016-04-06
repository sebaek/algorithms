package projectEuler;

public class Num6 {

	public static void main(String[] args) {
		System.out.println(solution(100));
	}
	
	
	public static long solution(long n) {
		long sum = n * (n+1) / 2;
		long result = 0;
		for (long i = 1; i <= n; i++) {
			result += (sum - i) * i;
		}
		
		return result;
	}
}
