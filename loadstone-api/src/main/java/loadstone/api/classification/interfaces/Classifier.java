package loadstone.api.classification.interfaces;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.model.DataModel;

import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 31.05.15.
 */
public interface Classifier {
    public List classify(DataModel model);
}
