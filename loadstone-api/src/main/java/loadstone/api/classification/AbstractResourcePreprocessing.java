package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.model.DataModel;

import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 23.04.15.
 */
public interface AbstractResourcePreprocessing {

    public DataModel preprocessDataModel(DataModel data);

    public List preprocessCollection(List<DataModel> collectionToBePreprocessed);

}
