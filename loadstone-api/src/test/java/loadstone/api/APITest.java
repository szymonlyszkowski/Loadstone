package loadstone.api;

import loadstone.model.object.LoadstoneTotalDataObjectModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class APITest {
    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel1;
    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel2;
    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModelEmpty;
    private API api;

    @Before
    public void prepareTotalData() {
        loadstoneTotalDataObjectModel1 = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModel2 = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModelEmpty = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModel1.setName("usługa");
        loadstoneTotalDataObjectModel2.setName("warsztat");
        loadstoneTotalDataObjectModelEmpty.setName("empty");
        api = new API();
    }



    @Test
    public void shouldReturnCategoryServices() {
        //assertEquals(NACE_Categories.SERVICES, api.analyzePlace(loadstoneTotalDataObjectModel1));
    }

    @Test
    public void shouldReturnCategoryAutomotive() {
        //assertEquals(NACE_Categories.AUTOMOTIVE,api.analyzePlace(loadstoneTotalDataObjectModel2));
    }

    @Test
    public void shouldNotReturnCategory() {
        assertEquals(NACE_Categories.NOT_CLASSIFIED, api.analyzePlace(loadstoneTotalDataObjectModelEmpty));
    }
}
