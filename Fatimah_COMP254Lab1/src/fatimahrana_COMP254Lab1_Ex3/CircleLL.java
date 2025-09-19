package fatimahrana_COMP254Lab1_Ex3;
//in this class I will create my node class, a circly linked list, and the method to clone the list. there will be a separate main class (Main3.java) to run the output.
//code (excluding textbook code) written by Fatimah Mohammed Rana for COMP254 Lab01

public class CircleLL<E> {


    private static class Node<E> implements Cloneable {

        private E element;
        private Node<E> next;


        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    private Node<E> tail = null;
    private Node<E> head = null;

    private int size = 0;                         // number of nodes in the list

    public CircleLL() {
    }             // constructs an initially empty list

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getNext().getElement();         // the head is *after* the tail
    }

    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    public void rotate() {         // rotate the first element to the back of the list
        if (tail != null)                // if empty, do nothing
            tail = tail.getNext();         // the old head becomes the new tail
    }


    public void addFirst(E e) {                // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);                     // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e);             // insert new element at front of list
        tail = tail.getNext();   // now new element becomes the tail
    }

    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) return null;              // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;           // must be the only node left
        else tail.setNext(head.getNext());       // removes "head" from the list
        size--;
        return head.getElement();
    }

    //creating clone method - based on singly linked clone. instead of going from head to null, traversing from head until i reach head again
    public CircleLL<E> clone() {
        CircleLL<E> cloned = new CircleLL<>();

        if (size>0) { //even if there are no values i can still get an output which is cool
            Node<E> head = tail.getNext();
            Node<E> cloneH = new Node<>(head.getElement(), null);
            cloned.tail = cloneH;

            Node<E> traverse = head.getNext();
            Node<E> clonedTail = cloneH;

            while (traverse != head) {
                Node<E> update = new Node<>(traverse.getElement(), null);
                clonedTail.setNext(update);
                clonedTail = update;
                traverse = traverse.getNext();
            }
                clonedTail.setNext(cloneH);
                cloned.tail = clonedTail;;
                cloned.size = this.size;
        }
        return cloned;
    }

    public String toString() {
        if (tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }


}
