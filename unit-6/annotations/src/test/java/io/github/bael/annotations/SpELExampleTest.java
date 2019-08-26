package io.github.bael.annotations;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpELExampleTest {

    @Test
    public void testMessage() {
        SpELExample sp = new SpELExample();
        assertEquals("Hello World!", sp.getString());
    }

    @Test
    public void testExpression() {
        SpELExample sp = new SpELExample();
        assertTrue(Integer.valueOf(16).equals(sp.getInt()));
    }

    @Test
    public void testVarMessage() {
        SpELExample sp = new SpELExample();
        assertEquals("SpELExample Hello World!", sp.getVarString());
    }
}