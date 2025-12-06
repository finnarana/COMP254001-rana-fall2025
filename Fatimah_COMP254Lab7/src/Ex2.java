//COMP254 Lab07 Ex2 | code by Fatimah Rana 301342519
import java.util.Comparator;

public class Ex2 {
    private static Queue<Integer> merge(Queue<Integer> s1, Queue<Integer> s2) {
        Queue<Integer> result = new LinkedQueue<>();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.first() <= s2.first())
                result.enqueue(s1.dequeue());
            else
                result.enqueue(s2.dequeue());
        }
        while (!s1.isEmpty()) result.enqueue(s1.dequeue());
        while (!s2.isEmpty()) result.enqueue(s2.dequeue());

        return result;
    }
    public static Queue<Integer> mergeSort(int[] arr) {
        Queue<Queue<Integer>> qofQ = new LinkedQueue<>();

        for (int value : arr) {
            Queue<Integer> single = new LinkedQueue<>();
            single.enqueue(value);
            qofQ.enqueue(single);
        }
        while (qofQ.size() > 1) {
            Queue<Integer> s1 = qofQ.dequeue();
            Queue<Integer> s2 = qofQ.dequeue();
            Queue<Integer> merged = merge(s1, s2);
            qofQ.enqueue(merged);
        }
        return qofQ.dequeue();
    }
    public static void main(String[] args) {
        int[] data = {22, 9, 5, 3, 6, 4, 11};

        Queue<Integer> sorted = mergeSort(data);

        System.out.print("after sort: ");
        while (!sorted.isEmpty())
            System.out.print(sorted.dequeue() + " ");
        System.out.println();
    }
}
