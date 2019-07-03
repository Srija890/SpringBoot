package com.stackroute.pe2;

import java.util.Scanner;

public class Palindrome {
        public static String palindromeMethod(String str){
            String str1="";
            for(int i=str.length()-1;i>=0;--i)
            {
                str1+=str.charAt(i);
            }
            if(str1==str)
            {
                return str;
            }
            else{
                return str1;
            }


        }
        public static void main(String args[])
        {
            Scanner s=new Scanner(System.in);
            String str,str1="",str3="";
            System.out.println("enter the string");
            str=s.next();
            palindromeMethod(str);
        }
    }







