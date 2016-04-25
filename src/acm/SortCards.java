package acm;
import java.util.*;


public class SortCards {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        int lines = scanner.nextInt();
 
        List<Long> list = new ArrayList<>();
         
        for (int i = 1; i <= lines; i++) {
            list.add(scanner.nextLong());
        }
        
        Collections.sort(list);
        
        long result = 0l;
        if (list.size() > 0) {
        	result = list.get(0);
        }
        
        if (list.size() > 1) {
        	result += list.get(1);
        }
        if (list.size() > 2) {
        	
        	for (int i = 2; i < list.size(); i++) {
        		result += result + list.get(i);
        	}
        } else if (list.size() == 2) {
        	result += list.get(1);
        }
        
        System.out.println(result);
         
        scanner.close();
	}
     
}