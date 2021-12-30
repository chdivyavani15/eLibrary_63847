package com.jtest;

import static org.junit.Assert.assertEquals;

public class Test {
	@org.junit.Test
    public void myTest()
    {
        assertEquals(16,Library.modelTest(1,15));
    }
}
