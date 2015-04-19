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

    private static LoadstoneDatabaseModel model;
    /**
     * Returns database with default name loadStoneDataBase.db
     *
     * @return LoadstoneDatabaseModel
     * @throws NoSuchFieldException
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static ObjectModel<TotalData, ResultSet, HashMap<String, Object>> getObjectModelSingleton()
            throws NoSuchFieldException, SQLException, ClassNotFoundException {
        model=new LoadstoneDatabaseModel();
        return model.getObjectModel(TotalData.class);
    }
}
