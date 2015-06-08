package loadstone.api;

import loadstone.api.classification.NaiveClassifier;
import loadstone.api.classification.loadstone.LoadstonePreprocessing;
import loadstone.api.classification.loadstone.LoadstoneSemiSupervisedClassifier;
import loadstone.api.connection.loadstone.LoadstoneDatabase;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class RealCategorizationAPITest {

    private ArrayList patternsToBeTrimmedFromConsideredDataModel;
    private ArrayList<String> patternsToLookForInLoadstoneDatabase;
    private DataModel dataModelConsidered;

    @Before
    public void prepareTotalData() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        patternsToLookForInLoadstoneDatabase = new ArrayList<>();
        patternsToLookForInLoadstoneDatabase.add("bankomat");
        patternsToBeTrimmedFromConsideredDataModel = new ArrayList();
        patternsToBeTrimmedFromConsideredDataModel.add("ul.");
        patternsToBeTrimmedFromConsideredDataModel.add("adres");
        patternsToBeTrimmedFromConsideredDataModel.add("\\.");
        List<DataModel> dataModels = new LoadstoneDatabase().returnResourceCollection(patternsToLookForInLoadstoneDatabase);
        dataModelConsidered = dataModels.get(0);
    }

    @Ignore("Maven cannot access database - need to be solved. When running from IDE works")
    @Test
    public void categorizeNaiveClassify() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        CategorizationAPI categorizationAPI = new CategorizationAPI(new NaiveClassifier(), dataModelConsidered, new LoadstonePreprocessing
                (patternsToBeTrimmedFromConsideredDataModel));
        System.out.println("Data model name before categorization process: " + categorizationAPI.getDataModel().getName());
        List<NACE_Categories> nace_categories = categorizationAPI.categorize();
        System.out.println("Data model name after categorization process: " + categorizationAPI.getDataModel().getName());
        System.out.println("Classified categories" + nace_categories.toString());
        Assertions.assertThat(nace_categories).containsExactly(NACE_Categories.NOT_CLASSIFIED);
    }

    @Ignore("Maven cannot access database - need to be solved. When running from IDE works")
    @Test
    public void categorizeSemiSupervised() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        CategorizationAPI categorizationAPI = new CategorizationAPI(new LoadstoneSemiSupervisedClassifier(), dataModelConsidered,
                new LoadstonePreprocessing(patternsToBeTrimmedFromConsideredDataModel));
        System.out.println("Data model name before categorization process: " + categorizationAPI.getDataModel().getName());
        List<NACE_Categories> nace_categories = categorizationAPI.categorize();
        System.out.println("Data model name after categorization process: " + categorizationAPI.getDataModel().getName());
        System.out.println("Classified categories" + nace_categories.toString());
        Assertions.assertThat(nace_categories).containsExactly(NACE_Categories.K, NACE_Categories.H);
    }
}
