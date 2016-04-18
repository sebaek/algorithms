package acm;

public class MaximumRandomWalk {
	static double result;
	static int index;
	static double lp, rp, cp;

	public static double solution(int steps, double llp, double rrp) {
		result = 0.0;
		index = 0;
		lp = llp;
		rp = rrp;
		cp = 1 - lp - rp;

		solution(steps, 0, 0, 1d);

		return (long) (result * 10000) / 10000d;
	}

	public static void solution(int steps, int current, int rightmost, double prob) {

		if (rightmost - current >= steps) {
			result += prob * rightmost;
			return;
		}

		solution(steps - 1, current + 1, Math.max(current + 1, rightmost), prob * rp);
		solution(steps - 1, current - 1, rightmost, prob * lp);

		if (cp != 0d) {
			solution(steps - 1, current, rightmost, prob * cp);
		}

	}

	public static void main(String[] args) {
//		System.out.println(solution(1, 0.5, 0.5));
		System.out.println(solution(1, 0.5, 0.5) == 0.5000);
//		System.out.println(solution(4, 0.5, 0.5));
		System.out.println(solution(4, 0.5, 0.5) == 1.1875);
//		System.out.println(solution(10, 0.5, 0.4));
		System.out.println(solution(10, 0.5, 0.4) == 1.4965);
		
//		System.out.println(solution(20, 0.5, 0.4));
//		System.out.println(solution(10, 0.5, 0.4) == 1.4965);
		
		long start = System.currentTimeMillis();
		System.out.println(solution(100, 0.5, 0.4));
		System.out.println(System.currentTimeMillis() - start);
//		System.out.println(solution(100, 0.5, 0.4) == 3.9995);
	}
}
