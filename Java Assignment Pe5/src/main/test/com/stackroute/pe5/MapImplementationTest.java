package com.stackroute.pe5;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.*;

public class MapImplementationTest
{
    MapImplementation mapimplementation;
    String expected = "", actual = "";

    @Before
    public void setUp() {
        mapimplementation = new MapImplementation();
    }

    @Test
    public void givenMapInputShouldSwapTheValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("val1", "java");
        map.put("val2", "c++");
        expected = "{val2=java, val1= }";
        actual = mapimplementation.stringChange(map);
        assertEquals(expected, actual);

    }

    @Test
    public void givenMapInputShouldSwapTheValuesMarsAndSaturn() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("val1", "mars");
        map.put("val2", "saturn");
        expected = "{val2=mars, val1= }";
        actual = mapimplementation.stringChange(map);
        assertEquals(expected, actual);

    }

    @After
    public void tearDown() {
        mapimplementation = null;
    }


}
