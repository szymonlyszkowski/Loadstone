package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.api.LoadstoneAPIUtils;
import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalData;
import org.junit.Before;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModel;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.04.15.
 */
public class LoadstonePreprocessingTest {

    private ArrayList patterns;

    @Before
    public void setUp() {
        patterns = new ArrayList();
        patterns.add("ul");
        patterns.add("adres");
        patterns.add("\\.");
    }

    @Test
    public void preprocessWholeDataBaseLoadstoneFromUl() throws SQLException, NoSuchFieldException, ClassNotFoundException {

        LoadstonePreprocessing preprocessing = new LoadstonePreprocessing(patterns);
        ObjectModel<LoadstoneTotalData, ResultSet, HashMap<String, Object>> objectModelSingleton = LoadstoneDatabase.getObjectModelSingleton();
        List<LoadstoneTotalData> allFromDB = objectModelSingleton.getAll(LoadstoneAPIUtils.prepareSqlQuery(patterns));
        List<DataModel> workingCollection = new ArrayList<>();
        workingCollection.addAll(allFromDB);
        objectModelSingleton.insertOrUpdateAll(preprocessing.preprocessCollection(workingCollection));

    }

    @Test
    public void preprocessLoadstoneDataModel() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        LoadstonePreprocessing preprocessing = new LoadstonePreprocessing(patterns);
        DataModel dataModel = new LoadstoneTotalData();
        dataModel.setName("adres ul ul. fake name to be trimmed ");
        DataModel preprocessedLoadstoneDataModel = preprocessing.preprocessDataModel(dataModel);
        assertEquals("fake name to be trimmed",preprocessedLoadstoneDataModel.getName());
    }

}
