package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalData;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModel;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.04.15.
 */
public class PreProcessingTest {

    @Test
    public void preprocessWholeDataBaseLoadstoneFromUl() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        Preprocessing preprocessing = new Preprocessing();
        ObjectModel<LoadstoneTotalData, ResultSet, HashMap<String, Object>> objectModelSingleton = LoadstoneDatabase.getObjectModelSingleton();
        List<LoadstoneTotalData> allFromDB = objectModelSingleton.getAll("name LIKE '%ul.%'");
        List<DataModel> all = new ArrayList<>();
        all.addAll(allFromDB);
        objectModelSingleton.insertOrUpdateAll(preprocessing.preprocessCollection(all));
    }
}
