package projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Num10 {
	
	static List<Long> primes = new ArrayList<>();
	public static void nextPrime() {
		long candidate = primes.get(primes.size()-1) + 1;
		
		outter:
		for (;candidate <= Integer.MAX_VALUE; candidate++) {
			long root = (long) Math.sqrt(candidate);
			for (long prime : primes) {
				if (prime <= root) {
					if (candidate % prime == 0) {
						continue outter;
					}
				} else {
					primes.add(candidate);
					return;
				}
			}
		}
		
	}
	
	public static long solution(long limit) {
		long sum = 0;
		
		
		
		
		while (primes.get(primes.size()-1) < limit) {
			nextPrime();
			
		}
		
		for (long prime : primes) {
			sum += prime;
		}
		
		sum -= primes.get(primes.size()-1);
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		ready();
		long test1 = solution(10l);
		System.out.printf("%s %d\n", test1 == 17, test1);
		
		ready();
		long test2 = solution(2000000l);
		System.out.printf("%s %d\n", test2 == 142913828922l, test2);
		
//		for (Long long1 : primes) {
//			System.out.println(long1);
//		}
	}
	
	public static void ready() {
		primes.clear();
		primes.add(2l);
	}

}
