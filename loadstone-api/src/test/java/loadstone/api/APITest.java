package loadstone.api;

import loadstone.model.object.TotalData;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class APITest {
    private TotalData totalData1;
    private TotalData totalData2;
    private TotalData totalDataEmpty;
    private API api;

    @Before
    public void prepareTotalData() {
        totalData1 = new TotalData();
        totalData1.setName("usługa");
//        totalData2 = new TotalData(0, 0, 0, 0, "warsztat", 0, 0, 0);
//        totalDataEmpty = new TotalData(0, 0, 0, 0, "empty", 0, 0, 0);
        api = new API();
    }



    @Test
    public void shouldReturnCategoryServices() {
        assertEquals(Categories.SERVICES, api.analyzePlace(totalData1));
    }

    @Test
    public void shouldReturnCategoryAutomotive() {
        assertEquals(Categories.AUTOMOTIVE,api.analyzePlace(totalData2));
    }

    @Test
    public void shouldNotReturnCategory() {
        assertEquals(Categories.NOT_CLASSIFIED, api.analyzePlace(totalDataEmpty));
    }
}
