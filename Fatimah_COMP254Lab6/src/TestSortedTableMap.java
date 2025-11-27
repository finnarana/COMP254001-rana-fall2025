//fatimah rana 301342519 COMP254
//Lab06 EX2
package maps;

public class TestSortedTableMap {

    public static void main(String[] args) {
        SortedTableMap<Integer,String> map = new SortedTableMap<>();

        map.put(9, "Nine");
        map.put(22, "TwentyTwo");
        map.put(3, null);



        System.out.println("ContainsKey(9) - " + map.containKey(10));
        System.out.println("ContainsKey(22) - " + map.containKey(22));
        System.out.println("ContainsKey(5) - " + map.containKey(5));
        System.out.println("ContainsKey(3) - " + map.containKey(3));

        System.out.println("get(3): " + map.get(3));
    }
}
