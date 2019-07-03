package com.stackroute.pe2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EvenNumberTest {
    EvenNumber evenNumber;

    @Before
    public void setUp() throws Exception {
        // This methods runs, before running any one of the test case
// This method is used to initialize the required variables
        evenNumber=new EvenNumber();
    }

    @After
    public void tearDown() throws Exception {
        // This method runs, after running all the test cases
// This method is used to clear the initialized variables
        evenNumber=null;
    }

    @Test
    public void isEven() {
        assertTrue(evenNumber.isEven(312));
    }
    @Test
    public void isOdd() {
        boolean expectedValue=false;
        boolean actualValue=evenNumber.isEven(313);
        assertEquals(expectedValue,actualValue);//checking expected and actual values

    }
    @Test
    public void isNotOdd() {
        boolean expectedValue=false;
        boolean actualValue=evenNumber.isEven(312);
        assertNotEquals(expectedValue,actualValue);//checking expected and actual values
    }

}