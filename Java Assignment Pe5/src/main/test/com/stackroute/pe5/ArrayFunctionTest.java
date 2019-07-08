package com.stackroute.pe5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayFunctionTest
{
    ArrayFunction arrayfunctions;
    String actual="",expected="";
    @Before
    public void setUp()
    {
        arrayfunctions=new ArrayFunction();
    }
    @Test
    public void givenInputArrayListShouldReturnSplitsByCommaOpearator()
    {
        expected = "[Kiwi, Grape, Mango, Berry]";
        actual = arrayfunctions.addArray("Kiwi Grape Mango Berry".split(" ")).toString();
        assertEquals(expected,actual);

    }
    @Test
    public void givenInputArrayListShouldReturnUpdatedList() {
        expected = "[Strawberry, Grape, Mango, Berry]";
        actual = arrayfunctions.addArray("Kiwi Grape Mango Berry".split(" ")).toString();
        String actual1 = arrayfunctions.update(0,"Strawberry").toString();
        assertEquals(expected,actual1);

    }
    @Test
    public void givenInputArrayListShouldReturnClearingAllTheElements() {
        expected = "[]";
        actual = arrayfunctions.addArray("Kiwi Grape Mango Berry".split(" ")).toString();
        String actual1 = arrayfunctions.remove().toString();
        assertEquals(expected,actual1);

    }
    @After
    public void tearDown()
    {
        arrayfunctions=null;
    }
}
