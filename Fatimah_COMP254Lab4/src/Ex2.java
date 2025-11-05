// COMP254 Lab04 | Example 2
// implemented code written by Fatimah Mohammed Rana 301342519

// Stack interface (textbook)
interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E pop();
}

// singly linked (textbook)
class SinglyLinkedList<E> {
    private static class Node<E> {
        E element;
        Node<E> next;
        Node(E e, Node<E> n) { element = e; next = n; }
    }

    private Node<E> head = null;
    private int size = 0;

    public void addFirst(E e) { head = new Node<>(e, head); size++; }
    public E removeFirst() {
        if (head == null) return null;
        E value = head.element;
        head = head.next;
        size--;
        return value;
    }
    public E first() { return (head != null) ? head.element : null; }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
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

// LinkedStack using SinglyLinkedList
class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public void push(E e) { list.addFirst(e); }
    public E pop() { return list.removeFirst(); }
    public E top() { return list.first(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public int size() { return list.size(); }
    public String toString() { return list.toString(); }
}

//my solution for transfer method
public class Ex2 {

    // transfers from S to T
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    // main
    public static void main(String[] args) {
        Stack<Integer> S = new LinkedStack<>();
        Stack<Integer> T = new LinkedStack<>();

        S.push(9);
        S.push(22);
        S.push(5);

        System.out.println("original S stack: " + S);
        System.out.println("original T stack: " + T);

        transfer(S, T);

        System.out.println("S transfer: " + S);
        System.out.println("T transfer: " + T);
    }
}
