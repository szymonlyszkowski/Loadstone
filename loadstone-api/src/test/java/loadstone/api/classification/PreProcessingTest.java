package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.junit.Test;

import java.sql.SQLException;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.04.15.
 */
public class PreProcessingTest {

    @Test
    public void demo2() throws SQLException, NoSuchFieldException, ClassNotFoundException {
       new PreProcessing().preprocess();
    }
}
