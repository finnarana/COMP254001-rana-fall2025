//Fatimah Rana 301342519 Centennial College || COMP254 Lab03 Ex02
//All code written by Fatimah Rana

//Write a short recursive Java method that determines if a string s is a palindrome, that is, it is equal to its reverse. Examples of palindromes include 'racecar' and 'gohangasalamiimalasagnahog'. Test the method by asking the user to provide string entries to be checked. Hint: Check the equality of the first and last characters and recur (but be careful to return the correct value for both odd and even-length strings).
public class FatimahRana_COMP254Lab3_Ex2 {

    public static void main(String[] args) {

        //x is 0 because first letter is at index 0, then the last r is the 7th letter, n-1 is 6
        boolean palindromeCheck = palindromeCheck(0, 6, "racecar"); //testing palindrome (true)
        boolean palindromeCheck1 = palindromeCheck(0, 6, "ratecar"); // testing word that has same x and y, but not palindrome (false)
        boolean palindromeCheck2 = palindromeCheck(0, 6, "nicecar"); // testing false (false)

        System.out.println(palindromeCheck);
        System.out.println(palindromeCheck1);
        System.out.println(palindromeCheck2);

    }
    //Check the equality of the first and last characters
    public static boolean palindromeCheck (int x, int y, String word){

        //x is the first character, y is the last character of the word.
        if (x ==y ) {
            return true;
        }
        //if the first letter and last letter arent the same, its not a palindrome so returnfalse
        if (word.charAt(x) != word.charAt((y))) {
            return false;
        }
        //increases x by 1, goes through each letter until the end
        x = x+1;
        //decreases y by 1, goes through eacch letter to the start
        y=y-1;
        return palindromeCheck(x,y,word);
    }
}
