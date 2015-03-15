package loadstone.api.connection;

import loadstone.model.database.LoadstoneDatabaseModel;

import java.sql.SQLException;

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
    public static LoadstoneDatabaseModel getLoadstoneSingleton(String databaseName) throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        LoadstoneDatabaseModel.setLoadstoneDatabaseName(databaseName);
        return loadstoneDatabaseModel;

    }

    public static LoadstoneDatabaseModel getDefaultLoadstoneSingleton() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        return new LoadstoneDatabaseModel();
    }
}
