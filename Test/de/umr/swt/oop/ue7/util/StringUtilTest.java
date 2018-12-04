package de.umr.swt.oop.ue7.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void substring() {

        // Case: standard
        Assert.assertEquals(
                "allo", StringUtil.substring("Hallo", 1, "Hallo".length())
        );

        Assert.assertEquals(
                null, StringUtil.substring(null, 1, 5)
        );

        Assert.assertEquals(
                "", StringUtil.substring("", 1, 3)
        );

        Assert.assertEquals(
                "allo", StringUtil.substring("Hallo", 1, 12)
        );

        Assert.assertEquals(
                "", StringUtil.substring("Hallo", 13, 4)
        );

    }
}