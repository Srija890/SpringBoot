package com.stackroute.pe2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    @Before
    private void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestlongFactorial() {
        assertEquals(120,Factorial.longFactorial(5));//checking expected and actual values
        assertEquals(2,Factorial.longFactorial(2));//checking expected and actual values
        assertEquals(1,Factorial.longFactorial(0));//checking expected and actual values

    }

}
