package projectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num25 {
	
	static List<byte[]> numbers = new ArrayList<>();
	
	static {
		numbers.add(new byte[]{1});
		numbers.add(new byte[]{1});
	}
	
	public static void main(String[] args) {
		int i = 100;
		byte[] f = fibonacci(100);
		
		while (f.length < 1000) {
			f = fibonacci(i++);
		}
		
		System.out.println(f.length);
		System.out.println(numbers.size());
		
		
	}
	
	
	public static byte[] fibonacci(int n) {
		if (numbers.size() >= n) {
			
			return numbers.get(n-1);
		}
		
		byte[] n1 = fibonacci(n-1);
		byte[] n2 = fibonacci(n-2);
		
		byte[] result = sum(n1, n2);
		numbers.add(result);
		
		return result;
	}


	private static byte[] sum(byte[] n1, byte[] n2) {
		byte[] l = n1.length <= n2.length ? n1 : n2;
		byte[] r = n1.length > n2.length ? n1 : n2;
		
		byte[] result = new byte[r.length];
		
		int i = 0;
		byte temp = 0;
		boolean carry = false;
		for (; i < l.length; i++) {
			
			temp = (byte) (l[i] + r[i] + result[i]);
			if (temp > 9) {
				carry = true;
			}
			
			if (carry && i < result.length-1) {
				result[i+1]++;
				carry = false;
			}
			result[i] = (byte) (temp % 10);
		}
		
		for (; i < r.length; i++) {
			temp = (byte) (r[i] + result[i]);
			if (temp > 9) {
				carry = true;
			}
			
			if (carry && i < result.length-1) {
				result[i+1]++;
				carry = false;
			}
			result[i] = (byte) (temp % 10);
		}
		
		if (carry) {
			result = Arrays.copyOf(result, result.length+1);
			result[result.length-1] = 1;
		}
		
		return result;
	}
	
	

}
