// COMP254 Lab04 | Example 1
// implemented code written by Fatimah Mohammed Rana 301342519

interface Position<E> {
    E getElement();
}

// linkedpositionallist (textbook)
class LinkedPositionalList<E> implements PositionalList<E> {
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) return null;
        return node;
    }

    public Position<E> first() { return position(header.getNext()); }
    public Position<E> last() { return position(trailer.getPrev()); }
    public Position<E> after(Position<E> p) {
        Node<E> node = (Node<E>) p;
        return position(node.getNext());
    }

    public Position<E> addLast(E e) {
        Node<E> newest = new Node<>(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newest);
        trailer.setPrev(newest);
        size++;
        return newest;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (Node<E> walk = header.getNext(); walk != trailer; walk = walk.getNext()) {
            sb.append(walk.getElement());
            if (walk.getNext() != trailer) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}

interface PositionalList<E> {
    int size();
    boolean isEmpty();
    Position<E> first();
    Position<E> last();
    Position<E> after(Position<E> p);
    Position<E> addLast(E e);
}
//my solution
public class Ex1 {
    public static <E> int indexOfP(PositionalList<E> list, Position<E> p) {
        int index = 0;
        for (Position<E> walk = list.first(); walk != null; walk = list.after(walk)) {
            if (walk == p) return index;
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        PositionalList<String> list = new LinkedPositionalList<>();
        Position<String> p1 = list.addLast("r");
        Position<String> p2 = list.addLast("a");
        Position<String> p3 = list.addLast("n");
        Position<String> p4 = list.addLast("a");

        System.out.println(indexOfP(list, p1));
        System.out.println(indexOfP(list, p2));
        System.out.println(indexOfP(list, p3));
        System.out.println(indexOfP(list, p4));
    }
}
