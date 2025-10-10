//Fatimah Rana 301342519 Centennial College || COMP254 Lab03 Ex01
//All code written by Fatimah Rana

//Create a recursive algorithm to compute the product of two positive integers, m and n, using only addition and subtraction. Implement the Java or Python code. Hint: You need subtraction to count down from m or n and addition to do the arithmetic needed to get the right answer. Check linearSum method from Week 5 examples.

//multiplication is just repeated adding. in theory i should be able to have x * y: add x a total of y times. i will have to use subtraction to reduce the number of times x is added, so it only adds y amount of times.
public class FatimahRana_COMP254Lab3_Ex1 {

    public static void main(String[] args) {

        int product = multiply(3,9);
        System.out.println(product);

    }
    public static int multiply(int x,int y) {
    //first check if the addition is complete (x is 0, meaning number of times that we add y is complete). if addition is not complete, keep adding x by y and reduce y by 1 until y=0.
        if (y == 0) {
            return 0;
        } else {
            return multiply(x, y-1) + x;
        }

    }

}
