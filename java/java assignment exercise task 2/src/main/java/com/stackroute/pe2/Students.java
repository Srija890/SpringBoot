package com.stackroute.pe2;

public class Students {
    public int average(int arr[])
    {
        int sum=0 ;
        for(int element:arr){
            sum+=element;
        }
        return sum/arr.length;

    }
    public int lowest(int arr[])
    {
        int minimum=arr[0] ;
        for(int element:arr){
            if(element<minimum)
                minimum=element;
        }
        return minimum;

    }
    public int highest(int arr[])
    {

        int maximum=arr[0] ;
        for(int element:arr){
            if(element> maximum)
                maximum=element;
        }
        return maximum;
    }
}

