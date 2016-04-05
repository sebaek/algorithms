package projectEuler;

public class Num2 {
	static long term1 = 1;
	static long term2 = 2;
	
	public static void main(String[] args) {
		long result = sumEvenTerm();
		System.out.println(result);
	}
	
	
	
	private static long sumEvenTerm() {
		long result = 2;
		long next;

		
		
		while ((next = getNextTerm()) <= 4000000) {
//			System.out.println(next);
			if (next % 2 == 0)
				result += next;
		}
		return result;
	}



	public static long getNextTerm() {
		long nextTerm = term1 + term2;
		term1 = term2;
		term2 = nextTerm;
		
		return nextTerm;
	}

}
