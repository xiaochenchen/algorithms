package com.xcc.primenumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 6/23/13
 * Time: 2:51 PM
 */
public class SieveOfEratosthenes {

    public static void main(String args[])
    {
        System.out.println("Please enter the upper limit for Sieve Of Eratothenes:");

        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.next());

        SieveOfEratosthenes soe = new SieveOfEratosthenes();
        soe.printPrimesLessThan(limit);
    }

    public void printPrimesLessThan(int limit)
    {
        boolean[] isPrime = new boolean[limit + 1]; // boolean array indicates if the index number is a prime
        Arrays.fill(isPrime, true); // default to true for all numbers
        isPrime[0] = false; isPrime[1] = false;

        for(int i = 2; i * i < limit + 1; ++i)
        {
            if(isPrime[i] == true)
            {
                for(int j = i * i; j < limit + 1; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < limit + 1; ++i)
        {
            if(isPrime[i] == true)
            {
                sb.append(i).append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
