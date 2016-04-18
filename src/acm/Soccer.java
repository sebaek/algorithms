package acm;

import java.util.HashSet;
import java.util.Set;

public class Soccer {
	static Set<Integer> primes = new HashSet<>();
	static double result;
	static double pro;
	
	static {
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		primes.add(17);
	}
	
	public static void solution(int term, int goals, double currentPro) {
		if (term == 1) {
			if (!primes.contains(goals)) {
				result += currentPro;
			}
			return;
		}
		
		solution(term-1, goals+1, currentPro*pro);
		solution(term-1, goals, currentPro*(1-pro));
		
		
	}
	
	
	public static void main(String[] args) {
		double wholeResult = 1d;
		
		result = 0d;
		pro = 50/100d;
		solution(18, 1, pro);
		solution(18, 0, 1-pro);
		
		wholeResult *= result;
		
		result = 0d;
		pro = 50/100d;
		solution(18, 1, pro);
		solution(18, 0, 1-pro);
		wholeResult *= result;
		
		System.out.println(1-wholeResult);
//		System.out.println(result);
		
		
		
	}

}
