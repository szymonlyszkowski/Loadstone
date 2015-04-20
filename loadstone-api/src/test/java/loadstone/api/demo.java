package loadstone.api;

import loadstone.api.classification.PreProcessing;
import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.object.TotalData;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author Szymon.Lyszkowski@gmail.com on 08.02.15.
 */

public class demo {

    @Test
    public void demo() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        ObjectModel<TotalData, ResultSet, HashMap<String, Object>> loadStoneDatabaseModel = LoadstoneDatabase.getObjectModelSingleton();
        System.out.println(loadStoneDatabaseModel.getAll().get(4).toString());
    }


}


