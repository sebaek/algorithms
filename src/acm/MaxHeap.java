package acm;
import java.util.*;

public class MaxHeap {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         
        int lines = scanner.nextInt();
 
         
        Heap heap = new Heap();
        for (int i = 1; i <= lines; i++) {
            long e = scanner.nextLong();
            if (e == 0) {
                long max = heap.removeMax();
                System.out.println(max);
            } else {
                heap.add(e);
            }
        }
         
        scanner.close();
    }
     
     
    static class Heap {
        List<Long> elements;
        int size;
        int length;
         
        public Heap() {
            this.elements = new ArrayList<>();
            this.elements.add(0l); //add dummy;
            this.size = 0;
            this.length = 0;
        }
         
        public void add(long e) {
            elements.add(e);
            size++;
             
            for (int i = size/2; i >= 1; i--) {
                maxHeapify(i);
            }
        }
        public long removeMax() {
            if (size > 0) {
                exchage(1, size);
                long max = elements.remove(size);
                size--;
                maxHeapify(1);
                 
                 
                return max;
            } else { 
                return 0l;
            }
        }
         
        private int parent(int i) {
            return i/2;
        }
         
        private int left(int i) {
            return i*2;
        }
         
        private int right(int i) {
            return i*2+1;
        }
         
        private void maxHeapify(int i) {
            int largest = 0;
             
            int l = left(i);
            int r = right(i);
             
            if (l <= size && elements.get(l) > elements.get(i)) {
                largest = l;
            } else {
                largest = i;
            }
             
            if (r <= size && elements.get(r) > elements.get(largest)) {
                largest = r;
            }
             
            if (largest != i) {
                exchage(largest, i);
                maxHeapify(i);
            }
        }
 
        private void exchage(int i, int j) {
            long temp = elements.get(i);
            elements.set(i, elements.get(j));
            elements.set(j, temp);
             
        }
         
         
    }
 
}
