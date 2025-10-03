/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


/**
 * Code for end-of-chapter exercises on asymptotics.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

// FATIMAH RANA - 301342519
    // My responses for COMP254 LAB02
    //EXERCISE 01
    //a)Give a big-Oh characterization, in terms of n, of the running time of the example1 method from Exercises.java class in Lesson 4 examples.
class Exercises {

  /** Returns the sum of the integers in given array. */
  public static int example1(int[] arr) {
    int n = arr.length, total = 0; // the array is set to the size of n (1), and the total is set to zero (1). there are two tasks being executed
    for (int j=0; j < n; j++)// loop from 0 to n-1. j=0 will run 1 time at the start of the loop (1), j<n checks if n has a greater value than j, if false loop ends. if true, loop will continue (n+1). j++ executes one time increasing the value by 1 n number of times (n)
      total += arr[j]; //the loop will continue n number of times after n > j (n).
    return total; // this statement will execute one task and return an integer that represents the final value of the array loop (1)
  } // final answer: based on the comments above, the equation would be (1)+(1)+(1)+(n+1)+(n)+(n). time complexity is O(n)


    //b)	Give a big-Oh characterization, in terms of n, of the running time of the example2 method from Exercises.java class in Lesson 4 examples.
  /** Returns the sum of the integers with even index in given array. */
  public static int example2(int[] arr) {
    int n = arr.length, total = 0; // the array is set to the size of n (1), the total is set to 0 (1), identical to ex1
    for (int j=0; j < n; j += 2)    // j=0 will run 1 time at the start of the loop (1), j<n checks if n has a greater value than j, if false loop ends. if true, loop will continue, but now j++ executes  time increasing the value by 2. this is half the values so 1+(n/2)
      total += arr[j]; // this loop is almost identical to exercise 1, however since there are half the increments it will be (n/2) as well
    return total; // this statement will execute one task and return an integer that represents the final value of the array loop (1)
  } // final answer: based on the comments above, the equation would be (1)+(1)+(1)+(n/2)+(n/2)+(n/2). time complexity is O(n)

    //c)
  /** Returns the sum of the prefix sums of given array. */
  public static int example3(int[] arr) {
    int n = arr.length, total = 0;// the array is set to the size of n (1), the total is set to 0 (1), identical to ex1, however there is a nested for loop.
    for (int j=0; j < n; j++) // sets j to zero, then checks if j  is less than n before executing the loop. the comparison is done n number of times until j is no longer less than n (n+1)
      for (int k=0; k <= j; k++) //k is set to zero, then every time that k is less than or = to j, k will increment from 0 to val of j.
        total += arr[j];            // the first loop runs (n) number of times. depending on (n), now the nested loop will also run that many times
      //essentially, if j is 0, the loop executes 1 task since 0 is equal to 0 (k<=j), if j is 1 then it executes 2, if j is 2 it executes 3, ... etc
    return total; // final answer: 1 + 2 + 3 + ... + n = n(n+1)/2. or n^2+1/2. time complexiity = On^2
  }

  //d)
  /** Returns the sum of the prefix sums of given array. */
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0; //3 tasks are executed here. n=array length (1) prefix =0 (1) and total = 0 (1)
    for (int j=0; j < n; j++) {     // sets j to 0 and checks if j is less than n prior to executing loop. comparison is done n number of times until j>n (n+1)
      prefix += arr[j];
      total += prefix;
    }
    return total;
  }

  //e)
  /** Returns the number of times second array stores sum of prefix sums from first. */
  public static int example5(int[] first, int[] second) { // assume equal-length arrays
    int n = first.length, count = 0;
    for (int i=0; i < n; i++) {     // loop from 0 to n-1
      int total = 0;
      for (int j=0; j < n; j++)     // loop from 0 to n-1
        for (int k=0; k <= j; k++)  // loop from 0 to j
          total += first[k];
      if (second[i] == total) count++;
    }
    return count;
  }

}
