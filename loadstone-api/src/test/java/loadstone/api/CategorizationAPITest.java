package loadstone.api;

import loadstone.model.object.LoadstoneTotalDataObjectModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class CategorizationAPITest {
    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel1;
    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel2;
    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModelEmpty;
    private CategorizationAPI categorizationApi;

    @Before
    public void prepareTotalData() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        loadstoneTotalDataObjectModel1 = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModel2 = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModelEmpty = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModel1.setName("usługa");
        loadstoneTotalDataObjectModel2.setName("warsztat");
        loadstoneTotalDataObjectModelEmpty.setName("empty");
        categorizationApi = new CategorizationAPI();
    }



    @Test
    public void shouldReturnCategoryServices() {
        assertEquals(NACE_Categories.NOT_CLASSIFIED, categorizationApi.analyzePlaceForFirstPhraseOccurrence(loadstoneTotalDataObjectModel1));
    }

    @Test
    public void shouldReturnCategoryAutomotive() {
        assertEquals(NACE_Categories.NOT_CLASSIFIED, categorizationApi.analyzePlaceForFirstPhraseOccurrence(loadstoneTotalDataObjectModel2));
    }

    @Test
    public void shouldNotReturnCategory() {
        assertEquals(NACE_Categories.NOT_CLASSIFIED, categorizationApi.analyzePlaceForFirstPhraseOccurrence(loadstoneTotalDataObjectModelEmpty));
    }
}
