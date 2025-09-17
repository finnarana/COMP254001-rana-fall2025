package fatimahrana_COMP254Lab1_Ex1;

//main for EX01
public class Main1 {

    public static void main(String[] args) {

        DLList<String> L = new DLList<>();
        DLList<String> M = new DLList<>();


        L.addFirst("R");
        L.addLast("A");
//        L.plist();

        M.addFirst("N");
        M.addLast("A");
        //M.plist();

        L.combine(M);

        L.plist();


    }
}
