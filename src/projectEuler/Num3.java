package projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Num3 {

	static List<Long> primes = new ArrayList<>();
	static List<Long> factors = new ArrayList<>();
	
	static long originaltarget = 600851475143l;
	
	public static void main(String[] args) {
		primes.add(2l);
		
		long target = originaltarget;
		long sqrtOfTarget = (long) Math.sqrt(target);
		
		int cursor = 0;
		while (cursor < primes.size()) {
			long prime = primes.get(cursor);
			if (prime <= sqrtOfTarget) {
				if (target % prime == 0) {
					factors.add(prime);
					target = target / prime;
					sqrtOfTarget = (long) Math.sqrt(target);
				} else {
					cursor++;
					if (cursor == primes.size()) {
						nextPrime();
					}
				}
			} else {
				factors.add(target);
				break;
			}
		}
		
		System.out.println(factors);
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
