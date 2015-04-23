package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalData;
import org.apache.commons.lang3.StringUtils;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.04.15.
 */
public class Preprocessing implements AbstractSourcePreprocessing {
    private ObjectModel<LoadstoneTotalData, ResultSet, HashMap<String, Object>> loadStoneDatabaseModel;
    private static final String NO_STRING = "";
    List<String> patterns;
    List<LoadstoneTotalData> all;

    public Preprocessing() throws ClassNotFoundException, NoSuchFieldException, SQLException {
        loadStoneDatabaseModel = LoadstoneDatabase.getObjectModelSingleton();
        all = loadStoneDatabaseModel.getAll("name LIKE '%ul.%'");
        patterns = new ArrayList<>();
        patterns.add("ul.");
    }

    @Override
    public DataModel preprocessDataModel(DataModel row, List<String> patterns) {
        String afterTrimming = preprocessName(row.getName(), patterns);
        DataModel preprocessedRow = new LoadstoneTotalData();
        preprocessedRow.setName(afterTrimming);
        return preprocessedRow;
    }

    @Override
    public List preprocessCollection(List<DataModel> collectionToBePreprocessed) {
        List<DataModel> preprocessedAll = new ArrayList<>();
        for (DataModel data : collectionToBePreprocessed) {
            preprocessedAll.add(preprocessDataModel(data, patterns));
        }
        return preprocessedAll;
    }

    private String preprocessName(String name, List<String> patterns) {
        String trimmedString = name;
        for (String pattern : patterns) {
            trimmedString = StringUtils.replacePattern(trimmedString, pattern, NO_STRING);
        }
        return trimmedString;
    }
}
