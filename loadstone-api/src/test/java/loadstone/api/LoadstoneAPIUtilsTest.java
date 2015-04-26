package loadstone.api;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 26.04.15.
 */
public class LoadstoneAPIUtilsTest {

    private static final String UL_OR_ADRES="name LIKE %ul.% OR name LIKE %adres%";
    private ArrayList<String> patterns;

    @Before()
    public void setUp(){
        patterns = new ArrayList<>();
        patterns.add("ul.");
        patterns.add("adres");
    }

    @Test
    public void shouldReturnSqlQueryForUL_OR_ADRES(){
       assertEquals(UL_OR_ADRES, LoadstoneAPIUtils.prepareSqlQuery(patterns));
    }
}
