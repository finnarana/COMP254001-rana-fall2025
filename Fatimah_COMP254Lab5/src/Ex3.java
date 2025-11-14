//Fatimah Rana | 301342519 | COMP254 Lab05
//Exercise03
import java.util.ArrayList;
import java.util.Comparator;

public class Ex3 {
    static class Entry<K,V> {
        private K key;
        private V value;
        public Entry(K key, V value) {
            this.key = key; this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    static class HeapPriorityQueue<K,V> {
        protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
        protected Comparator<K> comp;
        public HeapPriorityQueue() {
            // use natural ordering if no comparator given
            this((k1, k2) -> ((Comparable<K>) k1).compareTo(k2));
        }
        public HeapPriorityQueue(Comparator<K> comp) { this.comp = comp; }
        protected int parent(int j) { return (j-1)/2; }
        protected int left(int j) { return 2*j+1; }
        protected int right(int j) { return 2*j+2; }
        protected boolean hasLeft(int j) { return left(j) < heap.size(); }
        protected boolean hasRight(int j) { return right(j) < heap.size(); }
        protected void swap(int i, int j) {
            Entry<K,V> temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
        protected int compare(Entry<K,V> a, Entry<K,V> b) { return comp.compare(a.getKey(), b.getKey()); }

        //my code
        protected void upheap(int j) {
            if (j == 0) return;
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) < 0) {
                swap(j, p);
                upheap(p);
            }
        }
        protected void downheap(int j) {
            while (hasLeft(j)) {
                int leftIndex = left(j);
                int smallChildIndex = leftIndex;
                if (hasRight(j)) {
                    int rightIndex = right(j);
                    if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                        smallChildIndex = rightIndex;
                }
                if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) break;
                swap(j, smallChildIndex);
                j = smallChildIndex;
            }
        }

        protected void heapify() {
            int startIndex = parent(heap.size()-1);
            for (int j = startIndex; j >= 0; j--)
                downheap(j);
        }
        public int size() { return heap.size(); }
        public Entry<K,V> min() {
            if (heap.isEmpty()) return null;
            return heap.get(0);
        }
        public Entry<K,V> insert(K key, V value) {
            Entry<K,V> newest = new Entry<>(key, value);
            heap.add(newest);
            upheap(heap.size()-1);
            return newest;
        }
        public Entry<K,V> removeMin() {
            if (heap.isEmpty()) return null;
            Entry<K,V> answer = heap.get(0);
            swap(0, heap.size()-1);
            heap.remove(heap.size()-1);
            downheap(0);
            return answer;
        }
        public void printHeap() {
            for (Entry<K,V> e : heap)
                System.out.print("(" + e.getKey() + ", " + e.getValue() + ") ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        HeapPriorityQueue<String, String> heapQueue = new HeapPriorityQueue<>();
        heapQueue.insert("47", "A");
        heapQueue.insert("75", "C");
        heapQueue.insert("28", "B");
        heapQueue.insert("51", "D");
        heapQueue.insert("31", "F");
        heapQueue.insert("22", "G");
        heapQueue.insert("15", "H");
        heapQueue.printHeap();
        System.out.println("Min key: " + heapQueue.min().getKey());
    }
}
