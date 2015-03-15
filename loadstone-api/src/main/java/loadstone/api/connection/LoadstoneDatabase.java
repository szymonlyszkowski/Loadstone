package loadstone.api.connection;

import loadstone.model.database.LoadstoneDatabaseModel;
import loadstone.model.object.TotalData;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */

/**
 * Class for loadstone database access
 */
public class LoadstoneDatabase {
    /**
     * To avoid no argument default constructor creation
     */
    private LoadstoneDatabase() {
    }

    /**
     * Returns database with default name loadStoneDataBase.db
     *
     * @return LoadstoneDatabaseModel
     * @throws NoSuchFieldException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ObjectModel<TotalData, ResultSet, HashMap<String, Object>> getLoadstoneSingleton(String databaseName)
            throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel.setLoadstoneDatabaseName(databaseName);
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        return loadstoneDatabaseModel.getObjectModel(TotalData.class);
    }

    public static ObjectModel<TotalData, ResultSet, HashMap<String, Object>> getDefaultLoadstoneSingleton()
            throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel.setLoadstoneDatabaseName("loadStoneDataBase.db");
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        return loadstoneDatabaseModel.getObjectModel(TotalData.class);
    }
}
