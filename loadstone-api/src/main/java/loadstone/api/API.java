package loadstone.api;

import loadstone.model.object.LoadstoneTotalDataObjectModel;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class API {

    private CategoriesTree categoriesTree = new CategoriesTree();

    public NACE_Categories analyzePlace(LoadstoneTotalDataObjectModel place) {
        String placeName = place.getName();
        return analyzeName(placeName);
    }

    private NACE_Categories analyzeName(String poiDescription) {
        if (!isCategorized(poiDescription))
            return NACE_Categories.NOT_CLASSIFIED;
        else
            return poiClassify(poiDescription);
    }

    private boolean isCategorized(String poiDescription) {
        if (categoriesTree.getCategoriesTree().containsKey(poiDescription))
            return true;
        return false;
    }

    private NACE_Categories poiClassify(String poiDescription) {
        return categoriesTree.getCategoriesTree().get(poiDescription);
    }

}
