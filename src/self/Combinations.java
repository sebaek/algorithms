package self;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		
		for (long i = 0; i < 3; i++) {
			list.add(i);
		}
		
		List<List<Long>> result = combinations(list);
		
		for (List<Long> list2 : result) {
			System.out.println(list2);
		}
		
		
	}
	
	
	public static List<List<Long>> combinations(List<Long> list) {
		if (list.isEmpty()) {
			List<List<Long>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			return result;
		}
		
		List<List<Long>> result = new ArrayList<>();
		List<List<Long>> auxiliary = combinations(list.subList(0, list.size() - 1));
		
		for (List<Long> element : auxiliary) {
			result.add(element);
		}
		
		for (List<Long> element : auxiliary) {
			List<Long> des = new ArrayList<>();
			for (Long e : element) {
				des.add(e);
			}
			
			des.add(list.get(list.size()-1));
			
			result.add(des);
		}
		
		return result;
		
		
		
	}

}
