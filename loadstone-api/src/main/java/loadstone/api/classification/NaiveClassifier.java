package loadstone.api.classification;

import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

import java.util.*;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 27.05.15.
 */
public class NaiveClassifier {
    private static String NON_WORD_DELIMITER = "\\W";
    private static int NO_WORDS_TO_ANALYZE = 0;

    public NACE_Categories naiveClassify(DataModel dataModel) {
        String name = dataModel.getName();
        Bag categoryBag = listOfCategoriesWhichOccurredInName(name);
        HashMap<NACE_Categories, Integer> occurences = new HashMap<>();
        //itrate over counters check which are the most common, return both or more if the same value
        for (NACE_Categories category : NACE_Categories.values()) {
            occurences.put(category, categoryBag.getCount(category));
        }
        ArrayList occurrencesValues = new ArrayList(occurences.keySet());
        Collections.sort(occurrencesValues);

        return NACE_Categories.NOT_CLASSIFIED;
    }

    private Bag listOfCategoriesWhichOccurredInName(String name) {
        Bag categoryOccurrencesInName = new HashBag();
        String[] splitNames = name.split(NON_WORD_DELIMITER);
        if (splitNames == null || splitNames.length == NO_WORDS_TO_ANALYZE)
            return new HashBag(Arrays.asList(NACE_Categories.NOT_CLASSIFIED));
        for (String splitName : splitNames) {
            categoryOccurrencesInName.add(NACE_Categories.checkIfAnyCategoryContains(splitName));
        }
        return categoryOccurrencesInName;
    }


}
