package loadstone.api.classification;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import junit.framework.Assert;
import loadstone.api.LoadstoneAPIUtils;
import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.DataModel;
import loadstone.model.database.LoadstoneDatabaseModel;
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
import static junit.framework.TestCase.assertSame;

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
        assertEquals("fake name to be trimmed", preprocessedLoadstoneDataModel.getName());
    }

    @Test
    public void preprocessLoadstoneDataModelCollection() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        LoadstonePreprocessing preprocessing = new LoadstonePreprocessing(patterns);
        DataModel dataModelOld = new LoadstoneTotalData();
        dataModelOld.setName("adres ul. czechy 246");
        DataModel dataModelOld_1 = new LoadstoneTotalData();
        dataModelOld_1.setName("adres ul. kramarska 15 warszawa rembertów");
        ArrayList<DataModel> dataModelsOld = new ArrayList<>();
        dataModelsOld.add(dataModelOld);
        dataModelsOld.add(dataModelOld_1);
        ArrayList<DataModel> dataModelsNew = new ArrayList<>();
        DataModel dataModelNew = new LoadstoneTotalData();
        dataModelNew.setName("czechy 246");
        DataModel dataModelNew_1 = new LoadstoneTotalData();
        dataModelNew_1.setName("kramarska 15 warszawa rembertów");

        List preprocessedCollection = preprocessing.preprocessCollection(dataModelsOld);
        preprocessedCollection.get(0);
        assertEquals(dataModelNew, preprocessedCollection.get(0));
        assertEquals(dataModelNew_1, preprocessedCollection.get(1));
    }
}
