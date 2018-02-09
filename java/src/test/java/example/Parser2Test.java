package example;

import static org.junit.Assert.*;

import org.junit.Test;

public class Parser2Test {
    @Test 
    public void testSomeLibraryMethod() {
        Parser2 parser = new Parser2(null);
        //assertTrue();
        Record record = parser.parseLine("1 12345 Pipppo 12.3456");
        assertEquals(1, record.getIndex());
    }
}
