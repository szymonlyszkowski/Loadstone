package loadstone.api;

import loadstone.api.classification.NaiveClassifier;
import loadstone.api.classification.loadstone.LoadstonePreprocessing;
import loadstone.api.classification.loadstone.LoadstoneSemiSupervisedClassifier;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 08.06.15.
 */
public class CategorizationAPITest {

    private LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel1;
    private ArrayList patternsToBeTrimmedFromConsideredDataModel;

    @Before
    public void prepareTotalData() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        patternsToBeTrimmedFromConsideredDataModel = new ArrayList();
        loadstoneTotalDataObjectModel1 = new LoadstoneTotalDataObjectModel();
        loadstoneTotalDataObjectModel1.setName("bankomat and pizza");
    }

    @Test
    public void shouldReturnCategoryNotClassified() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        CategorizationAPI categorizationAPI = new CategorizationAPI(new NaiveClassifier(), loadstoneTotalDataObjectModel1,
                new LoadstonePreprocessing(patternsToBeTrimmedFromConsideredDataModel));
        System.out.println("Data model name before categorization process: " + categorizationAPI.getDataModel().getName());
        List<NACE_Categories> nace_categories = categorizationAPI.categorize();
        System.out.println("Data model name after categorization process: " + categorizationAPI.getDataModel().getName());
        System.out.println("Classified categories" + nace_categories.toString());
        assertEquals(Arrays.asList(NACE_Categories.NOT_CLASSIFIED), nace_categories);
    }

    @Test
    public void shouldReturnCategoryK_I() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        CategorizationAPI categorizationAPI = new CategorizationAPI(new LoadstoneSemiSupervisedClassifier(), loadstoneTotalDataObjectModel1,
                new LoadstonePreprocessing(patternsToBeTrimmedFromConsideredDataModel));
        System.out.println("Data model name before categorization process: " + categorizationAPI.getDataModel().getName());
        List<NACE_Categories> nace_categories = categorizationAPI.categorize();
        System.out.println("Data model name after categorization process: " + categorizationAPI.getDataModel().getName());
        System.out.println("Classified categories" + nace_categories.toString());
        Assertions.assertThat(nace_categories).containsExactly(NACE_Categories.I, NACE_Categories.K);

    }

}
