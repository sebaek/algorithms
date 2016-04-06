package projectEuler;

import java.math.BigInteger;

public class Num20 {
	public static void main(String[] args) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= 100; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		System.out.println(result);
		
		long sum = 0;
		while (!result.equals(BigInteger.ZERO)) {
			BigInteger[] dr = result.divideAndRemainder(BigInteger.TEN);
			result = dr[0];
			sum += dr[1].longValue();
		}
		
		System.out.println(sum);

	}

}
