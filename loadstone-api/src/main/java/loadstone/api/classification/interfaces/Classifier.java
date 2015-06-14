package loadstone.api.classification.interfaces;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;

import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 31.05.15.
 */
public interface Classifier {
    public List<NACE_Categories> classify(DataModel model);
}
