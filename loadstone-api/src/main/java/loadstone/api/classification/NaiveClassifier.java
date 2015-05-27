package loadstone.api.classification;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multisets;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 27.05.15.
 */
public class NaiveClassifier {
    private static String NON_WORD_DELIMITER = "\\W";
    public NACE_Categories naiveClassify(DataModel dataModel) {
        String name = dataModel.getName();
        List<NACE_Categories> categoriesWhichOccurredInName = listOfCategoriesWhichOccurredInName(name);
        NACE_Categories mostCommon = Multisets.copyHighestCountFirst(ImmutableMultiset.copyOf(categoriesWhichOccurredInName))
                .iterator().next();
        return mostCommon;
    }

    private List<NACE_Categories> listOfCategoriesWhichOccurredInName(String name) {
        List<NACE_Categories> categoryOccurrencesInName = new ArrayList();
        String[] splitNames = name.split(NON_WORD_DELIMITER);
        for (String splitName : splitNames) {
            categoryOccurrencesInName.add(NACE_Categories.checkIfAnyCategoryContains(splitName));
        }
        return categoryOccurrencesInName;
    }
}
