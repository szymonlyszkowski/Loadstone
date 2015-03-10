package loadstone.connection;

import loadstone.model.database.LoadstoneDatabaseModel;
import org.junit.Test;

import java.sql.SQLException;

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
