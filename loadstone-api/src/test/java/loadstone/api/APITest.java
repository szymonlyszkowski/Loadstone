package loadstone.api;

import loadstone.model.object.LoadstoneTotalData;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class APITest {
    private LoadstoneTotalData loadstoneTotalData1;
    private LoadstoneTotalData loadstoneTotalData2;
    private LoadstoneTotalData loadstoneTotalDataEmpty;
    private API api;

    @Before
    public void prepareTotalData() {
        loadstoneTotalData1 = new LoadstoneTotalData();
        loadstoneTotalData1.setName("usługa");
//        totalData2 = new TotalData(0, 0, 0, 0, "warsztat", 0, 0, 0);
//        totalDataEmpty = new TotalData(0, 0, 0, 0, "empty", 0, 0, 0);
        api = new API();
    }



    @Test
    public void shouldReturnCategoryServices() {
        assertEquals(Categories.SERVICES, api.analyzePlace(loadstoneTotalData1));
    }

    @Test
    public void shouldReturnCategoryAutomotive() {
        assertEquals(Categories.AUTOMOTIVE,api.analyzePlace(loadstoneTotalData2));
    }

    @Test
    public void shouldNotReturnCategory() {
        assertEquals(Categories.NOT_CLASSIFIED, api.analyzePlace(loadstoneTotalDataEmpty));
    }
}
