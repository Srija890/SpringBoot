package com.stackroute.pe2;

public class Factorial {
    public static long longFactorial(long MAX_VALUE)
    {
        long fact=1;
        for(int i=1;i<=MAX_VALUE;i++)
        {
            fact=fact*i;
        }
        return fact;
    }
}


