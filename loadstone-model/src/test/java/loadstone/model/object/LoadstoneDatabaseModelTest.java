package loadstone.model.object;

import loadstone.model.database.LoadstoneDatabaseModel;
import org.junit.Test;
import za.co.neilson.sqlite.orm.ObjectModelColumn;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 01.03.15.
 */
public class LoadstoneDatabaseModelTest {

    private static final String[] TOTAL_DATA_COLUMNS = { "name", "latitude", "longitude", "accuracy", "satellites", "priority", "userid", "id" };

    @Test
    public void shouldReturnTotalDataClass() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        assertEquals(LoadstoneTotalDataObjectModel.class, loadstoneDatabaseModel.getObjectModel(LoadstoneTotalDataObjectModel.class).getObjetType());
    }

    @Test
    public void shouldCheckTotalDataTableColumns() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        ObjectModelColumn[] totalDataColumns = loadstoneDatabaseModel.getObjectModel(LoadstoneTotalDataObjectModel.class).getObjectModelColumns();
        assertEquals(TOTAL_DATA_COLUMNS.length, totalDataColumns.length);
        for (int i = 0; i < TOTAL_DATA_COLUMNS.length; ++i) {
            assertEquals(TOTAL_DATA_COLUMNS[i].toString(), totalDataColumns[i].getName());
        }
    }

    @Test
    public void shouldReturn6thDatabaseRow() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        LoadstoneDatabaseModel loadstoneDatabaseModel = new LoadstoneDatabaseModel();
        List<LoadstoneTotalDataObjectModel> all = loadstoneDatabaseModel.getObjectModel(LoadstoneTotalDataObjectModel.class).getAll();
        assertEquals(all.get(6).toString(), "TotalData{Accuracy=1.0, Name='adres  rzechta 52', Latitude=5.15935989E8, Longitude=1.88483558E8, Satellites=0, "
                + "Priority=0, Userid=12345, Id=748717}");
    }

}
