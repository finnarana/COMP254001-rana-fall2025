// COMP254 Lab04 | Example 3
// implemented code written by Fatimah Mohammed Rana 301342519

public class Ex3 {

    // singly linked and node - textbook
    static class SinglyLinkedList<E> {
        private static class Node<E> {
            E element;
            Node<E> next;

            Node(E e, Node<E> n) {
                element = e;
                next = n;
            }
        }

        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public SinglyLinkedList() {
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() {
            if (isEmpty()) return null;
            return head.element;
        }

        public E last() {
            if (isEmpty()) return null;
            return tail.element;
        }

        public void addFirst(E e) {
            head = new Node<>(e, head);
            if (size == 0)
                tail = head;
            size++;
        }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (isEmpty())
                head = newest;
            else
                tail.next = newest;
            tail = newest;
            size++;
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            E answer = head.element;
            head = head.next;
            size--;
            if (size == 0)
                tail = null;
            return answer;
        }

        // implementation for O(1) concat
        public void concatenate(SinglyLinkedList<E> other) {
            if (other.isEmpty()) return;
            if (this.isEmpty()) {
                this.head = other.head;
                this.tail = other.tail;
                this.size = other.size;
            } else {
                this.tail.next = other.head;
                this.tail = other.tail;
                this.size += other.size;
            }
            other.head = null;
            other.tail = null;
            other.size = 0;
        }

        // added toString to print queue contents
        public String toString() {
            StringBuilder sb = new StringBuilder("(");
            Node<E> current = head;
            while (current != null) {
                sb.append(current.element);
                current = current.next;
                if (current != null) sb.append(", ");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    // LinkedQueue - textbook
    static class LinkedQueue<E> {
        private SinglyLinkedList<E> list = new SinglyLinkedList<>();

        public LinkedQueue() {}

        public int size() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void enqueue(E e) {
            list.addLast(e);
        }

        public E first() {
            return list.first();
        }

        public E dequeue() {
            return list.removeFirst();
        }

        public String toString() {
            return list.toString();
        }

        // concat implementation
        public void concatenate(LinkedQueue<E> Q2) {
            list.concatenate(Q2.list);
        }
    }

    // main for testing with toString
    public static void main(String[] args) {
        LinkedQueue<Integer> q1 = new LinkedQueue<>();
        LinkedQueue<Integer> q2 = new LinkedQueue<>();

        q1.enqueue(9);
        q1.enqueue(22);
        q1.enqueue(5);

        q2.enqueue(4);
        q2.enqueue(3);
        q2.enqueue(6);

        System.out.println("Q1: " + q1);
        System.out.println("Q2: " + q2);

        q1.concatenate(q2);

        System.out.println("Q1 concat: " + q1);
        System.out.println("Q2 concat: " + q2);
    }
}
