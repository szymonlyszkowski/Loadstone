package loadstone.api.classification.loadstone;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.api.classification.interfaces.Classifier;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 07.06.15.
 */
public class LoadstoneSemiSupervisedClassifier implements Classifier {

    private HashMap<String, NACE_Categories> loadstoneBOW = LoadstoneBOW.getLoadstoneBOW();
    private List<NACE_Categories> classifiedCategories = new ArrayList<>();

    private List<NACE_Categories> semiSupervisedClassify(DataModel dataModel) {
        String nameConsidered = dataModel.getName();
        for (String nameToClassify : loadstoneBOW.keySet()) {
            if (nameConsidered.contains(nameToClassify)) {
                classifiedCategories.add(loadstoneBOW.get(nameToClassify));
            }
        }
        if (classifiedCategories.isEmpty()) {
            return Arrays.asList(NACE_Categories.NOT_CLASSIFIED);
        }
        return classifiedCategories;
    }

    @Override
    public List classify(DataModel model) {
        return semiSupervisedClassify(model);
    }
}
