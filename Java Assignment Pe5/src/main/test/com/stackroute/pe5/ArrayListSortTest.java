package com.stackroute.pe5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ArrayListSortTest {
    ArrayListSort arrayListSort;
    @Before
    public void setUp() throws Exception {
        arrayListSort=new ArrayListSort();
    }

    @After
    public void tearDown() throws Exception {
        arrayListSort=null;
    }
    @Test
    public void sortArrayList(){
        arrayListSort=new ArrayListSort();
        SortedSet<String> sort=new TreeSet<String>();
        sort.add("harry");
        sort.add("annie");
        sort.add("zenny");
        sort.add("potter");
        sort.add("bunny");
        ArrayList<String> result=arrayListSort.sortList(sort);
        System.out.println(result);
        ArrayList<String> res1=new ArrayList<>();
        res1.add("annie");
        res1.add("bunny");
        res1.add("harry");
        res1.add("potter");
        res1.add("zenny");
        assertEquals(res1,result);
    }
}


