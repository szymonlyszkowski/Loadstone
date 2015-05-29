package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 29.05.15.
 */
public class ClassificationUtilsTest {

    @Test
    public void shouldReturnHighest_10(){
        Integer [] integers = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> highestValuesFromSortedList = ClassificationUtils.getHighestValuesFromSortedList(Arrays.asList(integers));
        assertEquals(Arrays.asList(10),highestValuesFromSortedList);
    }
    @Test
    public void shouldReturnHighest_10_10(){
        Integer [] integers = {1,2,3,4,5,6,7,8,10,10};
        List<Integer> highestValuesFromSortedList = ClassificationUtils.getHighestValuesFromSortedList(Arrays.asList(integers));
        assertEquals(Arrays.asList(10,10),highestValuesFromSortedList);
    }

    @Test
    public void shouldReturnHighest_10_10_10(){
        Integer [] integers = {1,2,3,4,5,6,7,10,10,10};
        List<Integer> highestValuesFromSortedList = ClassificationUtils.getHighestValuesFromSortedList(Arrays.asList(integers));
        assertEquals(Arrays.asList(10,10,10),highestValuesFromSortedList);
    }
    @Test
    public void shouldReturnHighestOnes(){
        Integer [] integers = {1,1,1,1,1,1,1,1,1,1};
        List<Integer> highestValuesFromSortedList = ClassificationUtils.getHighestValuesFromSortedList(Arrays.asList(integers));
        assertEquals(Arrays.asList(1,1,1,1,1,1,1,1,1,1),highestValuesFromSortedList);
    }

    @Test
    public void shouldReturnHighest_1(){
        Integer [] integers = {0,1};
        List<Integer> highestValuesFromSortedList = ClassificationUtils.getHighestValuesFromSortedList(Arrays.asList(integers));
        assertEquals(Arrays.asList(1),highestValuesFromSortedList);
    }

    @Test
    public void shouldReturnHighest1(){
        Integer [] integers = {0,0,1};
        List<Integer> highestValuesFromSortedList = ClassificationUtils.getHighestValuesFromSortedList(Arrays.asList(integers));
        assertEquals(Arrays.asList(1),highestValuesFromSortedList);
    }
}
