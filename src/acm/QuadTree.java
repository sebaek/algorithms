package acm;

public class QuadTree {
	
	static String result = "";

	public static String solution(String[][] input, int x, int y, int d) {
		if (d == 1) {
			return input[x][y];
		}
		d = d/2;
		String topLeft = solution(input, x, y, d);
		String topRight = solution(input, x, y+d, d);
		String bottomLeft = solution(input, x+d, y, d);
		String bottomRight = solution(input, x+d, y+d, d);
		
		if (topLeft.length() == 1
				&& topLeft.equals(topRight) 
				&& bottomLeft.equals(bottomRight)
				&& topLeft.equals(bottomLeft)) {
			return topLeft;
		} else {
			return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
		}
	}
	
	public static void main(String[] args) {
		String[][] input1 = {{"1","1","1","1","0","0","0","0"},
							{"1","1","1","1","0","0","0","0"},
							{"0","0","0","1","1","1","0","0"},
							{"0","0","0","1","1","1","0","0"},
							{"1","1","1","1","0","0","0","0"},
							{"1","1","1","1","0","0","0","0"},
							{"1","1","1","1","0","0","1","1"},
							{"1","1","1","1","0","0","1","1"}};
		
		String[][] input2 = {{"1","1","1","1"},
							 {"1","1","1","1"},
							 {"0","0","0","1"},
							 {"0","0","0","1"}};
		
		String output1 = solution(input1, 0, 0, 8);
		System.out.println(output1);
		System.out.println(output1.equals("((110(0101))(0010)1(0001))"));
		
		String output2 = solution(input2, 0, 0, 4);
		System.out.println(output2);
		System.out.println(output2.equals("(110(0101))"));
				
	}
}
