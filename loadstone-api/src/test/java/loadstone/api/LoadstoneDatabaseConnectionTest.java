package loadstone.api;

import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.database.LoadstoneDatabaseModel;
import loadstone.model.object.TotalData;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 01.03.15.
 */
public class LoadstoneDatabaseConnectionTest {

    private static final String DATABASE_NAME = "loadStoneDataBase.db";
    private static final int DATABASE_VERSION = 1;

    @Test
    public void shouldReadDatabase() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadStoneDatabaseModel = new LoadstoneDatabaseModel();
        assertNotNull(loadStoneDatabaseModel);
    }

    @Test
    public void shouldReadDatabaseSingletonDefault() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        ObjectModel<TotalData, ResultSet, HashMap<String, Object>> loadStoneDatabaseModel = LoadstoneDatabase.getDefaultLoadstoneSingleton();
        assertNotNull(loadStoneDatabaseModel);
    }

    @Test
    public void shouldReadDatabaseSingletonNameDefined() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        ObjectModel<TotalData, ResultSet, HashMap<String, Object>> loadStoneDatabaseModel = LoadstoneDatabase.getLoadstoneSingleton(DATABASE_NAME);
        assertNotNull(loadStoneDatabaseModel);
    }

    @Test
    public void shouldReadDatabaseName() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadStoneDatabaseModel = new LoadstoneDatabaseModel();
        assertEquals(DATABASE_NAME, loadStoneDatabaseModel.getDatabaseName());
    }

    @Test
    public void shouldReadDatabaseVersion() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        assertEquals(DATABASE_VERSION, loadstoneDatabaseModel.getDatabaseVersion());
    }

}
