package projectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num20 {
	static Map<Long, Long> factors = new HashMap<>();
	static List<Long> primes = new ArrayList<>();

	

	public static void main(String[] args) {
		primes.add(2l);
		for (int i = 2; i <= 100; i++) {
			factors(i);
		}
		System.out.println(factors);
		
		factors.put(2l, factors.get(2l) - factors.get(5l));
		factors.remove(5l);
//		factors.remove(1l);
		
		System.out.println(factors);
		
	}
	
	public static void factors(long target) {
		
		System.out.print("target : " + target + "\t");
		
		
//		long target = originaltarget;
		long sqrtOfTarget = (long) Math.sqrt(target);
		
		int cursor = 0;
		while (cursor < primes.size()) {
			long prime = primes.get(cursor);
			if (prime <= sqrtOfTarget) {
				if (target % prime == 0) {
//					factors.add(prime);
					addToMap(prime);
					target = target / prime;
					sqrtOfTarget = (long) Math.sqrt(target);
				} else {
					cursor++;
					if (cursor == primes.size()) {
						nextPrime();
					}
				}
			} else {
//				factors.add(target);
				addToMap(target);
				break;
			}
		}
		
		System.out.println(factors);
		
//		return factors;
	}
	
	private static void addToMap(Long prime) {

		if (factors.containsKey(prime)) {
			factors.put(prime, factors.get(prime) + 1);
		} else {
			factors.put(prime, 1l);
		}
	}
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
}
