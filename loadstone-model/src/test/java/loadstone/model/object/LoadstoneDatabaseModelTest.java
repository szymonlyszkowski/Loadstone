package loadstone.model.object;

import loadstone.model.database.LoadstoneDatabaseModel;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModelColumn;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 01.03.15.
 */
public class LoadstoneDatabaseModelTest {

    private static final String[] TOTAL_DATA_COLUMNS = { "name", "latitude", "longitude", "accuracy", "satellites", "priority", "userid", "id" };

    @Test
    public void shouldReturnTotalDataClass() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        assertEquals(LoadstoneTotalData.class, loadstoneDatabaseModel.getObjectModel(LoadstoneTotalData.class).getObjetType());
    }

    @Test
    public void shouldCheckTotalDataTableColumns() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        ObjectModelColumn[] totalDataColumns = loadstoneDatabaseModel.getObjectModel(LoadstoneTotalData.class).getObjectModelColumns();
        assertEquals(TOTAL_DATA_COLUMNS.length, totalDataColumns.length);
        for (int i = 0; i < TOTAL_DATA_COLUMNS.length; ++i) {
            assertEquals(TOTAL_DATA_COLUMNS[i].toString(), totalDataColumns[i].getName());
        }
    }

}
