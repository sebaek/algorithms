package clrs;

public class InsertionSort {
	public static void main(String[] args) {
		int[] list = {29, 23, 98, 8, 0, 40, 2, 55, 60, 38, 64, 7, 62, 30, 41, 30, 4, 7, 55, 70};
		
//		sort(list, (l, r) -> l < r);
		sort(list);

		for (int i : list) {
			System.out.print(i + ", ");
		}
		
	}
	
	// insertion sort
	public static void sort(int[] list) {
		for (int j = 1; j < list.length; j++) {
			int key = list[j];
			int i = j-1;
			while (i>=0 && list[i] > key) {
				list[i+1] = list[i];
				i--;
			}
			list[i+1] = key;
		}
	}
	
	
	// insertion sort of Strategy Design pattern
	public static void sort(int[] list, SortStrategy order) {
		for (int j = 1; j < list.length; j++) {
			int key = list[j];
			int i = j-1;
			while (i>=0 && order.way(list[i], key)) {
				list[i+1] = list[i];
				i--;
			}
			list[i+1] = key;
		}
	}

	interface SortStrategy {
		boolean way(int let, int right);
	}
}
