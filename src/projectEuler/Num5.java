package projectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num5 {

	static List<Long> primes = new ArrayList<>();
	static Map<Long, Long> commonFactors = new HashMap<>();
	
	static long originaltarget = 4;
	
	public static void main(String[] args) {
		primes.add(2l);
		for (int i = 2; i <= 20; i++) {
			Map<Long, Long> factors = factors(i);
			for (Long factor : factors.keySet()) {
				if (commonFactors.containsKey(factor)) {
					commonFactors.put(factor, Math.max(commonFactors.get(factor), factors.get(factor)));
				} else {
					commonFactors.put(factor, factors.get(factor));
				}
			}
//			System.out.println(factors);
		}
		System.out.println(commonFactors);
		
		long result = 1;
		for (Long factor : commonFactors.keySet()) {
			for (long i = 0; i < commonFactors.get(factor); i++) {
				result *= factor;
			}
		}
		System.out.println(result);
		
	}
	
	public static Map<Long, Long> factors(long target) {
		Map<Long, Long> factors = new HashMap<>();
		
		System.out.print("target : " + target + "\t");
		
		
//		long target = originaltarget;
		long sqrtOfTarget = (long) Math.sqrt(target);
		
		int cursor = 0;
		while (cursor < primes.size()) {
			long prime = primes.get(cursor);
			if (prime <= sqrtOfTarget) {
				if (target % prime == 0) {
//					factors.add(prime);
					addToMap(factors, prime);
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
				addToMap(factors, target);
				break;
			}
		}
		
		System.out.println(factors);
		
		return factors;
	}
	
	private static void addToMap(Map<Long, Long> factors, Long prime) {

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
