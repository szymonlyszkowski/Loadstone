package loadstone.api;

import loadstone.api.connection.LoadstoneDatabase;
import loadstone.model.database.LoadstoneDatabaseModel;
import loadstone.model.object.TotalData;
import org.junit.Before;
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
    private static final String COLUMN_0_TOKEN = "name";
    private LoadstoneDatabaseModel loadStoneDatabaseModel;
    ObjectModel<TotalData, ResultSet, HashMap<String, Object>> loadStoneObjectModel;

    @Before
    public void prepareModel() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        loadStoneDatabaseModel = new LoadstoneDatabaseModel();
        loadStoneObjectModel = LoadstoneDatabase.getObjectModelSingleton();
    }

    @Test
    public void shouldReadDatabase() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        assertNotNull(loadStoneDatabaseModel);
    }

    @Test
    public void shouldReadDatabaseSingletonNameDefined() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        assertNotNull(loadStoneObjectModel);
    }

    @Test
    public void shouldReadDatabaseName() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        assertEquals(DATABASE_NAME, loadStoneDatabaseModel.getDatabaseName());
    }

    @Test
    public void shouldReadDatabaseVersion() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        assertEquals(DATABASE_VERSION, loadStoneDatabaseModel.getDatabaseVersion());
    }

    @Test
    public void shouldReturnRowName() throws ClassNotFoundException, NoSuchFieldException, SQLException {
       assertEquals(COLUMN_0_TOKEN,loadStoneObjectModel.getObjectModelColumns()[0].getName());
    }

}
