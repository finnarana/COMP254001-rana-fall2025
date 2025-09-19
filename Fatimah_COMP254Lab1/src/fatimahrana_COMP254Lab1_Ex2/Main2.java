package fatimahrana_COMP254Lab1_Ex2;

public class Main2 {

    public static void main(String[] args) {
        SinglyLinked<String> list = new SinglyLinked<String>();
        list.addFirst("MSP");
        list.addLast("ATL");
        list.addLast("BOS");
        list.addFirst("LAX");

        System.out.println(list);

        list.swapNodes();
        System.out.println("swapped first and second");
        System.out.println(list);

    }
}
