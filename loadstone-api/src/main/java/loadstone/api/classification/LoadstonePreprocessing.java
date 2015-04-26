package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.04.15.
 */
public class LoadstonePreprocessing implements AbstractResourcePreprocessing {
    private static final String EMPTY_STRING="";
    private List<String> patterns;

    public LoadstonePreprocessing(ArrayList patterns) throws ClassNotFoundException, NoSuchFieldException, SQLException {
        this.patterns = patterns;
    }

    @Override
    public DataModel preprocessDataModel(DataModel row) {
        String afterTrimming = preprocessName(row.getName(), patterns);
        DataModel preprocessedRow = new LoadstoneTotalDataObjectModel();
        preprocessedRow.setName(afterTrimming);
        return preprocessedRow;
    }

    @Override
    public List preprocessCollection(List<DataModel> collectionToBePreprocessed) {
        List<DataModel> preprocessedAll = new ArrayList<>();
        for (DataModel data : collectionToBePreprocessed) {
            preprocessedAll.add(preprocessDataModel(data));
        }
        return preprocessedAll;
    }

    private String preprocessName(String name, List<String> patterns) {
        /**
         * Cuts leading and trailing whitespaces from source string
         */
        String trimmedString = name.trim();
        for (String pattern : patterns)
            trimmedString = StringUtils.replace(trimmedString, pattern, EMPTY_STRING);
        for (String pattern : patterns)
            trimmedString = StringUtils.replacePattern(trimmedString, pattern, EMPTY_STRING);
        /**
         *  Cuts leading and trailing whitespaces from preprocessed string
         */
        return trimmedString.trim();
    }

    public List<String> getAppliedPatterns() {
        return patterns;
    }
}
