package loadstone.api;

import loadstone.model.object.LoadstoneTotalData;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class API {

    private CategoriesTree categoriesTree = new CategoriesTree();

    public Categories analyzePlace(LoadstoneTotalData place) {
        String placeName = place.getName();
        return analyzeName(placeName);
    }

    private Categories analyzeName(String poiDescription) {
        if (!isCategorized(poiDescription))
            return Categories.NOT_CLASSIFIED;
        else
            return poiClassify(poiDescription);
    }

    private boolean isCategorized(String poiDescription) {
        if (categoriesTree.getCategoriesTree().containsKey(poiDescription))
            return true;
        return false;
    }

    private Categories poiClassify(String poiDescription) {
        return categoriesTree.getCategoriesTree().get(poiDescription);
    }

}
