package projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Num7 {
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
	
	public static void main(String[] args) {
		primes.add(2l);
		while (primes.size() < 10001) {
			nextPrime();
		}
		System.out.println(primes.get(10000));
	}

}
