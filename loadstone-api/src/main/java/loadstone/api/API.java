package loadstone.api;

import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class API {

    public NACE_Categories analyzePlace(DataModel place) {
        String placeName = place.getName();
        return analyzeName(placeName);
    }

    private NACE_Categories analyzeName(String poiDescription) {
        return NACE_Categories.checkIfAnyCategoryContains(poiDescription);
    }

}
