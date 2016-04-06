package acm;

public class TowerOfHanoi {

	public static void solution(int n, int beg, int aux, int end) {
		if (n == 1) {
			System.out.println(beg + " " + end);
			return;
		}
		
		solution(n-1, beg, end, aux);
		solution(1, beg, aux, end);
		solution(n-1, aux, beg, end);
	}
	
	public static void main(String[] args) {
		solution(3, 1, 2, 3);
	}
}
