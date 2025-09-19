package fatimahrana_COMP254Lab1_Ex2;
//in this class I will create my node class, a singly linked list, and the method to swap two nodes. there will be a separate main class (Main2.java) to run the output.
//code (except for textbook code) written by Fatimah Mohammed Rana for COMP254 Lab01
public class SinglyLinked<E> implements Cloneable {

    private static class Node<E> {

        private E element;            // reference to the element stored at this node

        private Node<E> next;         // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        // Accessor methods
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        // Modifier methods

        public void setNext(Node<E> n) {
            next = n;
        }

    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null;               // head node of the list (or null if empty)
    private Node<E> tail = null;               // last node of the list (or null if empty)
    private int size = 0;                      // number of nodes in the list


    public SinglyLinked() {
    }              // constructs an initially empty list

    // access methods


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {                // adds element e to the front of the list
        head = new Node<>(e, head);              // create and link a new node
        if (size == 0)
            tail = head;                           // special case: new node becomes tail also
        size++;
    }

    public void addLast(E e) {                 // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
        if (isEmpty())
            head = newest;                         // special case: previously empty list
        else
            tail.setNext(newest);                  // new node after existing tail
        tail = newest;                           // new node becomes the tail
        size++;
    }

    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) return null;              // nothing to remove
        E answer = head.getElement();
        head = head.getNext();                   // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null;                           // special case as list is now empty
        return answer;
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinked other = (SinglyLinked) o;   // use nonparameterized type
        if (size != other.size) return false;
        Node walkA = head;                               // traverse the primary list
        Node walkB = other.head;                         // traverse the secondary list
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;   // if we reach this, everything matched successfully
    }
//use for ex3
    @SuppressWarnings({"unchecked"})
    public SinglyLinked<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        SinglyLinked<E> other = (SinglyLinked<E>) super.clone(); // safe cast
        if (size > 0) {                    // we need independent chain of nodes
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();      // walk through remainder of original list
            Node<E> otherTail = other.head;     // remember most recently created node
            while (walk != null) {              // make a new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);     // link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    public int hashCode() {
        int h = 0;
        for (Node walk = head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
            h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
        }
        return h;
    }

    //method to swap the nodes (basically creating a head as a pointer and finding the next node after to be the second node, then pointing second node to the first node and vice versa

    public void swapNodes() {
        if (head.getNext() == null) return;
        Node<E> pointer = head;
        int count = 0;

        while (pointer != null && count < 1) { //as long as the pointer exists it will do the loop once,
            Node<E> n1 = pointer;
            Node<E> n2 = pointer.getNext();

            if (n2 != null) {
                n1.setNext(n2.getNext());
                n2.setNext(n1);
                head = n2;

            if (n1.getNext() == null) {
                tail = n1;
            }
        }
        count++;
        pointer = pointer.getNext();

    }
}
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}
