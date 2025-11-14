//Fatimah Rana | 301342519 | COMP254 Lab05
//Exercise01
// worst case run time is O(n)

class TNode {
    int value;
    TNode left, right, parent;

    TNode(int value) {
        this.value = value;
    }
}

public class Ex1 {

    public static TNode postorderNext(TNode p) {
        if (p == null) return null;

        TNode parent = p.parent;

        if (parent == null) return null;

        if (p == parent.left) {

            if (parent.right != null) {
                TNode next = parent.right;


                while (next.left != null || next.right != null) {
                    if (next.left != null) next = next.left;
                    else next = next.right;
                }
                return next;
            }
            return parent;
        }

        return parent;
    }
    public static void main(String[] args) {


        TNode n1 = new TNode(1);
        TNode n2 = new TNode(2);
        TNode n3 = new TNode(3);
        TNode n4 = new TNode(4);
        TNode n5 = new TNode(5);
        TNode n6 = new TNode(6);
        TNode n7 = new TNode(7);

        n4.left = n2; n4.right = n6;
        n2.parent = n4; n6.parent = n4;

        n2.left = n1; n2.right = n3;
        n1.parent = n2; n3.parent = n2;

        n6.left = n5; n6.right = n7;
        n5.parent = n6; n7.parent = n6;

        TNode[] testOrder = {n1, n2, n3, n4, n5, n6, n7};

        for (TNode n : testOrder) {
            TNode next = postorderNext(n);
            if (next != null)
                System.out.println("postorderNext(p): " + n.value + " is " + next.value);
            else
                System.out.println("postorderNext(p):  " + n.value + " is null");
        }
    }
}
