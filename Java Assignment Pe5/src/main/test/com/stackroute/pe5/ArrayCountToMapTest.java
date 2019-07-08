package com.stackroute.pe5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ArrayCountToMapTest {
    ArrayCountToMap arrayCountToMap;
    @Before
    public void setUp() throws Exception {
        arrayCountToMap=new ArrayCountToMap();
    }

    @After
    public void tearDown() throws Exception {
        arrayCountToMap=null;
    }
    @Test
    public void givenInputStringShouldCountOccuranceOfString(){
        arrayCountToMap=new ArrayCountToMap();
        String str="one__ two,one two three,four";
        Map<String,Integer> result=arrayCountToMap.countOccurances(str);
        Map<String,Integer> map=new HashMap<>();
        map.put("one",2);
        map.put("two",2);
        map.put("three",1);
        map.put("four",1);
        assertEquals(map,result);
    }
    @Test
    public void givenInputShouldCountOccurranceOfStringTest(){
        arrayCountToMap=new ArrayCountToMap();
        String str="1 ? 1 .,2";
        Map<String,Integer> result=arrayCountToMap.countOccurances(str);
        Map<String,Integer> map=new HashMap<>();
        map.put("1",2);
        map.put("2",1);
        assertEquals(map,result);


    }
}


