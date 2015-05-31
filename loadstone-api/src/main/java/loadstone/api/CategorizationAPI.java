package loadstone.api;

import loadstone.api.classification.interfaces.AbstractResourcePreprocessing;
import loadstone.api.classification.interfaces.Classifier;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;

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

    /**
     * Look for category in given patterns and return first encountered category which contains if found else return NOT_CLASSIFIED
     *
     * @param place
     * @return
     */
    public NACE_Categories analyzePlaceForFirstPhraseOccurrence(DataModel place) {
        String placeName = place.getName();
        return analyzeName(placeName);
    }

    private NACE_Categories analyzeName(String poiDescription) {
        return NACE_Categories.retrunCategoryIfFirstEncounteredContains(poiDescription);
    }

}
