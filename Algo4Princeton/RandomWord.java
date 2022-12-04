package Algo4Princeton;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: reads a sequence of words from standard input and prints one of those words uniformly at random.
 * Do not store the words in an array or list. Instead, use Knuth’s method:
 * when reading the ith word, select it with probability 1/i to be the champion,
 * replacing the previous champion. After reading all of the words, print the surviving champion.
 * @author: PlusL
 * @create: 2022-11-30 13:52
 **/
public class RandomWord {
    public static void main(String[] args) {

        /*
         *  I tried to run the official case, but I could not stop the input
         *  (the input of the program could not be stopped by entering or blank space,
         *  and the program was always in the input state without turning to the output
         *  of the executive program), so I tried to read the source code and read and
         *  write it in the way of Scanner
         */
        Scanner sc = new Scanner(System.in);

        String champion = null;
        int count = 0;
        // read a line of input , then split it by " "(blank space)
        String[] str = sc.nextLine().split(" ");

        for (int i = 1; i < str.length; i++) {

        }
        StdOut.println(champion);
    }

}
