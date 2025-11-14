//Fatimah Rana | 301342519 | COMP254 Lab05
//Exercise02

public class Ex2 {

    public static int postHeight(TNode node) {
        if (node == null) return -1;
        int leftHeight = postHeight(node.left);
        int rightHeight = postHeight(node.right);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        System.out.println("Node: " + node.value + ", Height: " + currHeight);
        return currHeight;
    }

    public static void main(String[] args) {
        TNode n4 = new TNode(4);
        TNode n2 = new TNode(2);
        TNode n6 = new TNode(6);
        TNode n1 = new TNode(1);
        TNode n3 = new TNode(3);
        TNode n5 = new TNode(5);
        TNode n7 = new TNode(7);
        n4.left = n2; n4.right = n6;
        n2.left = n1; n2.right = n3;
        n6.left = n5; n6.right = n7;
        postHeight(n4);
    }
}
