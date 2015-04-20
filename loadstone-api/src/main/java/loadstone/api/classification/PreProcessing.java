package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.object.TotalData;
import org.apache.commons.lang3.StringUtils;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.04.15.
 */
public class PreProcessing {
   private ObjectModel<TotalData, ResultSet, HashMap<String, Object>> loadStoneDatabaseModel;

    public PreProcessing() throws ClassNotFoundException, NoSuchFieldException, SQLException {
        loadStoneDatabaseModel = LoadstoneDatabase.getObjectModelSingleton();
    }

    public void preprocess() throws SQLException {
        List<TotalData> all = loadStoneDatabaseModel.getAll("name LIKE '%ul.%'");

        for(TotalData data: all){
            System.out.println("before"+data);
            String afterTrimming = StringUtils.replacePattern(data.getName(), "ul.", "");
            data.setName(afterTrimming);
            System.out.println("after"+data);
        }
    }
}
