package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 27.05.15.
 */
public class NaiveClassifierTest {

    @Test
    public void shouldReturnCategoryC(){
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("Manufacturing Manufacturing Manufacturing Manufacturing Manufacturing Manufacturing administration administration administration");
        NaiveClassifier naiveClassifier = new NaiveClassifier();
        NACE_Categories selectedCategory = naiveClassifier.naiveClassify(model);
        assertEquals(NACE_Categories.C, selectedCategory);
    }
}
