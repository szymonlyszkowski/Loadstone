package loadstone.api.classification.loadstone;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.google.common.collect.Lists;
import loadstone.api.classification.interfaces.Classifier;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 07.06.15.
 */
public class LoadstoneSemiSupervisedClassifier implements Classifier {

    private HashMap<String, NACE_Categories> loadstoneBOW = LoadstoneBOW.getLoadstoneBOW();
    private Bag classifiedCategories = new HashBag();
    private static String NON_WORD_DELIMITER = "\\s++";

    private List<NACE_Categories> semiSupervisedClassify(DataModel dataModel) {
        String[] nameConsidered = dataModel.getName().split(NON_WORD_DELIMITER);
        for (String nameToClassify : loadstoneBOW.keySet()) {
            if (Arrays.asList(nameConsidered).contains(nameToClassify)) {
                classifiedCategories.add(loadstoneBOW.get(nameToClassify));
            }
        }
        if (classifiedCategories.isEmpty()) {
            return Arrays.asList(NACE_Categories.NOT_CLASSIFIED);
        }
        return Lists.newArrayList(classifiedCategories.uniqueSet());
    }

    @Override
    public List classify(DataModel model) {
        return semiSupervisedClassify(model);
    }
}
