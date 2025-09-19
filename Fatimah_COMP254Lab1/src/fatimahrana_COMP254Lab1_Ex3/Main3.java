package fatimahrana_COMP254Lab1_Ex3;


public class Main3 {

    //main method
    public static void main(String[] args)  {
        //(LAX, MSP, ATL, BOS)
        CircleLL<String> circularList = new CircleLL<String>();

        circularList.addFirst("LAX");
        circularList.addLast("MSP");
        circularList.addLast("ATL");
        circularList.addLast("BOS");

        CircleLL<String> cloneCircleList = circularList.clone();

        //x.clone().equals(x)3
        System.out.println("Circular List -- " + circularList);
        System.out.println("Cloned List -- " + cloneCircleList);

        //
    }


}
