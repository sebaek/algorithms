package acm;

import java.util.*;

public class MinHeap {
 
     
    public static void main(String[] args) {
 
//        Scanner scanner = new Scanner(System.in);
         
//        int lines = scanner.nextInt();
    	int lines = 100000;
    	long start = System.currentTimeMillis();
    	Random rand = new Random(System.currentTimeMillis());
         
        Heap heap = new Heap();
        for (int i = 1; i <= lines; i++) {
            long e = rand.nextLong();
            if (e == 0) {
                long min = heap.removeMin();
//                System.out.println(min);
            } else {
                heap.add(e);
            }
        }
        System.out.println(System.currentTimeMillis() - start);
         
//        scanner.close();
         
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
                minHeapify(i);
            }
        }
        public long removeMin() {
            if (size > 0) {
                exchage(1, size);
                long min = elements.remove(size);
                size--;
                minHeapify(1);
                 
                 
                return min;
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
         
        private void minHeapify(int i) {
            int smallest = 0;
             
            int l = left(i);
            int r = right(i);
             
            if (l <= size && elements.get(l) < elements.get(i)) {
                smallest = l;
            } else {
                smallest = i;
            }
             
            if (r <= size && elements.get(r) < elements.get(smallest)) {
                smallest = r;
            }
             
            if (smallest != i) {
                exchage(smallest, i);
                minHeapify(i);
            }
        }
 
        private void exchage(int i, int j) {
            long temp = elements.get(i);
            elements.set(i, elements.get(j));
            elements.set(j, temp);
             
        }
         
         
    }
 
 
}