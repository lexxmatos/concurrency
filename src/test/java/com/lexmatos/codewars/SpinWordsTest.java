package com.lexmatos.codewars;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SpinWordsTest {
    @Test
    public void test() {
    	Assert.assertEquals("erdnaxela",  new SpinWords().spinWords("alexandre"));
        Assert.assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        Assert.assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    	
    }
}
