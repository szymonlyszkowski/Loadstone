package loadstone.api.classification;

import loadstone.api.classification.loadstone.LoadstoneSemiSupervisedClassifier;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 08.06.15.
 */
public class LoadstoneSemiSupervisedClassifierTest {

    @Test
    public void shouldReturnCategoryNotClassified() {
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("Manufacturing Manufacturing Manufacturing Manufacturing Manufacturing Manufacturing administration administration administration");
        LoadstoneSemiSupervisedClassifier loadstoneSemiSupervisedClassifier = new LoadstoneSemiSupervisedClassifier();
        List<NACE_Categories> selectedCategory = loadstoneSemiSupervisedClassifier.classify(model);
        assertEquals(Arrays.asList(NACE_Categories.NOT_CLASSIFIED), selectedCategory);
    }

    @Test
    public void shouldReturnCategoryK() {
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("bankomat");
        LoadstoneSemiSupervisedClassifier loadstoneSemiSupervisedClassifier = new LoadstoneSemiSupervisedClassifier();
        List<NACE_Categories> selectedCategory = loadstoneSemiSupervisedClassifier.classify(model);
        Assertions.assertThat(selectedCategory).containsExactly(NACE_Categories.K);
    }

    @Test
    public void shouldReturnCategoryK_I() {
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("bankomat and pizza");
        LoadstoneSemiSupervisedClassifier loadstoneSemiSupervisedClassifier = new LoadstoneSemiSupervisedClassifier();
        List<NACE_Categories> selectedCategory = loadstoneSemiSupervisedClassifier.classify(model);
        Assertions.assertThat(selectedCategory).containsExactly(NACE_Categories.I, NACE_Categories.K);
    }
}



