package loadstone.api;

import loadstone.api.classification.loadstone.LoadstonePreprocessing;
import loadstone.api.connection.loadstone.LoadstoneDatabase;
import loadstone.api.connection.loadstone.LoadstoneDatabaseUpdater;
import loadstone.api.utils.LoadstoneAPIUtils;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import org.junit.Ignore;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@gmail.com on 08.02.15.
 */

public class RealLoadStoneDataBaseTest {

    @Ignore("Running from IDE works but when running by maven fails dunno why!")
    @Test
    public void shouldReturn4thTuple() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModel.setName("adres  rzechta 56");
        loadstoneTotalDataObjectModel.setAccuracy(1.0);
        loadstoneTotalDataObjectModel.setLatitude(5.15930122E8);
        loadstoneTotalDataObjectModel.setLongitude(1.88457292E8);
        loadstoneTotalDataObjectModel.setSatellites(0);
        loadstoneTotalDataObjectModel.setPriority(0);
        loadstoneTotalDataObjectModel.setUserid(12345);
        loadstoneTotalDataObjectModel.setId(748715);
        DataModel dataModel = new LoadstoneDatabase().returnResource("4");
        assertEquals(loadstoneTotalDataObjectModel, dataModel);
    }

    @Ignore("Turn on only when want to update whole data base using preprocessing with given patterns")
    @Test
    public void preprocessWholeDataBaseLoadstoneFromUl() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        ArrayList patterns = new ArrayList();
        patterns.add("ul");
        patterns.add("adres");
        patterns.add(".");
        LoadstonePreprocessing preprocessing = new LoadstonePreprocessing(patterns);
        ObjectModel<LoadstoneTotalDataObjectModel, ResultSet, HashMap<String, Object>> objectModelSingleton = LoadstoneDatabaseUpdater.getObjectModelSingleton();
        List<LoadstoneTotalDataObjectModel> allFromDB = objectModelSingleton.getAll(LoadstoneAPIUtils.prepareSqlQuery(patterns));
        List<DataModel> workingCollection = new ArrayList<>();
        workingCollection.addAll(allFromDB);
        objectModelSingleton.insertOrUpdateAll(preprocessing.preprocessCollection(workingCollection));

    }

}


