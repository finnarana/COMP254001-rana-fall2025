package fatimahrana_COMP254Lab1_Ex1;
//in this class I will create my node class, 2 doubly linked lists, and the method to combine the two lists. there will be a separate main class (Main1.java) to run the output.
//code written by Fatimah Mohammed Rana for COMP254 Lab01

public class DLList<E> {

    private static class Node<E> { //node class
        private final E element;
        private Node<E> next;
        private Node<E> pre;

        public Node(E e, Node<E> n, Node<E> p) {
            element = e;
            next = n;
            pre = p;
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
        public Node<E> getPre() {
            return pre;
        }
        public void setPre(Node<E> n) {
            pre = n;
        }
    } //end node class

    private final Node<E> header;
    private final Node<E> trailer;
    private int size = 0;

    public DLList() {

        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, null);
        header.setNext(trailer);
        trailer.setPre(header);
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPre().getElement();
    }

    public void addFirst(E element) {
        addBetween(element, header, header.getNext());
    }

    public void addLast(E element) {
        addBetween(element, trailer.getPre(), trailer);
    }

    public void addBetween(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(element, successor, predecessor);
        predecessor.setNext(newest);
        successor.setPre(newest);
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPre());
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPre();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPre(predecessor);
        size--;

        return node.getElement();
    }
    public void plist() {
        System.out.println("my list: ");
        Node<E> begin = header.getNext();

        while (begin != trailer) {
            System.out.print(begin.getElement());
            //System.out.println(begin.getElement()); lines
            begin = begin.getNext();
        }
        System.out.println();
    }
    public void combine(DLList<E> comlist) {
        if (comlist.isEmpty())
            return;

        //hint - Connect the end of L into the beginning of M: going to try finding the ends of each node and directing them to each other
        Node<E> beginM = comlist.header.getNext();
        Node<E> endOfL = comlist.trailer.getPre();

        this.trailer.getPre().setNext(beginM);
        beginM.setPre(this.trailer.getPre());

        endOfL.setNext(this.trailer);
        this.trailer.setPre(endOfL);

        this.size = comlist.size;

        comlist.header.setNext(comlist.trailer);
        comlist.trailer.setPre(comlist.header);
        comlist.size = 0;
    }
} //end ex1
