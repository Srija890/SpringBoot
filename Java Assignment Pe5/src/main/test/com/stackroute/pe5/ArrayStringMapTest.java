package com.stackroute.pe5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ArrayStringMapTest {
    ArrayStringMap arrayStringMap;
    @Before
    public void setUp() throws Exception {
        arrayStringMap=new ArrayStringMap();
    }
    @After
    public void tearDown() throws Exception {
        arrayStringMap=null;
    }
    @Test
    public void convertArrayToMap(){
        arrayStringMap=new ArrayStringMap();
        String[] arr={"a","b","a","a","c","c","d"};
        Map<String,Boolean> res=arrayStringMap.arrayToMap(arr);
        Map<String,Boolean> result=new HashMap<String,Boolean>();
        result.put("a",true);
        result.put("b",false);
        result.put("c",true);
        result.put("d",false);
        assertEquals(result,res);
    }
    @Test
    public void givenStringArray_SameItemsAreAlsoSent_ShouldReturnTrueOrFalseCorresponding() {
        arrayStringMap = new ArrayStringMap();
        String[] str = {"one", "two", "three", "one", "two"};
        Map<String,Boolean> res= arrayStringMap.arrayToMap(str);
        Map<String,Boolean> result=new HashMap<String,Boolean>();
        result.put("one",true);
        result.put("two",true);
        result.put("three",false);
        assertEquals(result,res);
    }
}
