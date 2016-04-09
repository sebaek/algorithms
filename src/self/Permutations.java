package self;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		
		List<Long> list = new ArrayList<>();
		
		for (long i = 0; i < 9; i++) {
			list.add(i);
		}
		
		List<List<Long>> permutations = permutations(list);
		
		for (List<Long> list2 : permutations) {
			System.out.println(list2);
		}
		
	}
	
	public static List<List<Long>> permutations(List<Long> list) {
		if (list.size() == 1) {
			List<List<Long>> result = new ArrayList<>();
			result.add(list);
			return result;
		}

		
		List<List<Long>> result = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			Object firstElement = list.get(i);
			List<Long> subList = subList(list, i);
			List<List<Long>> auxiliary = permutations(subList);
			
			for (List<Long> aux : auxiliary) {
				aux.add(0, list.get(i));
				result.add(aux);
			}
		}
		
		return result;
		

		
		
	}

	private static List<Long> subList(List<Long> list, int index) {
		List<Long> result = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (i != index) {
				result.add(list.get(i));
			}
		}
		return result;
	}
}
