package loadstone.connection;

import loadstone.model.database.LoadstoneDatabaseModel;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 01.03.15.
 */
public class LoadstoneDatabaseConnectionTest {
    @Test
    public void shouldReadDatabase() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadStoneDatabaseModel = new LoadstoneDatabaseModel();
        assertNotNull(loadStoneDatabaseModel);
    }

}
