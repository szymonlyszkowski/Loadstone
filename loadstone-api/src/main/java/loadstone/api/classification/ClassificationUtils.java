package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 29.05.15.
 */
public class ClassificationUtils {

    public static List<Integer> getHighestValuesFromSortedList(List<Integer> inputValues) {
        if(inputValues.isEmpty())
            return new ArrayList<>();
        else if(inputValues.size()==1)
            return inputValues;
        int counter = inputValues.size() - 2;
        int highestElement = inputValues.get(inputValues.size() - 1);
        if (highestElement > inputValues.get(counter))
            return Arrays.asList(highestElement);
        List<Integer> highestElements = new ArrayList<>();
        highestElements.add(highestElement);
        while (counter >= 0) {
            if(inputValues.get(counter)<highestElement)
                return highestElements;
            if (inputValues.get(counter).equals(highestElement)) {
                highestElements.add(inputValues.get(counter));
            }
            --counter;
        }
        return highestElements;
    }
}
