package loadstone.api;

import loadstone.api.classification.interfaces.AbstractResourcePreprocessing;
import loadstone.api.classification.interfaces.Classifier;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;

import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class CategorizationAPI {

    private AbstractResourcePreprocessing preprocessing;
    private DataModel dataModel;
    private Classifier classifier;

    public CategorizationAPI() {
    }

    public CategorizationAPI(DataModel dataModel, AbstractResourcePreprocessing preprocessing) {
        this.dataModel = dataModel;
        this.preprocessing = preprocessing;
    }

    public CategorizationAPI(Classifier classifier, DataModel dataModel, AbstractResourcePreprocessing preprocessing) {
        this.classifier = classifier;
        this.dataModel = dataModel;
        this.preprocessing = preprocessing;
    }

    public List<NACE_Categories> categorize() {
        dataModel = preprocessing.preprocessDataModel(dataModel);
        return classifier.classify(dataModel);
    }

    public DataModel getDataModel() {
        return dataModel;
    }

}
