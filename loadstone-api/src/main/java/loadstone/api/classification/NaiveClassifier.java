package loadstone.api.classification;

import loadstone.api.classification.interfaces.Classifier;
import loadstone.model.DataModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

import java.util.*;

public class NaiveClassifier implements Classifier {
    private static String NON_WORD_DELIMITER = "\\W";
    private static int NO_WORDS_TO_ANALYZE = 0;

    private List<NACE_Categories> naiveClassify(DataModel dataModel) {
        String name = dataModel.getName();
        Bag categoryBag = listOfCategoriesWhichOccurredInName(name);

        HashMap<NACE_Categories, Integer> occurrences = new HashMap<>();
        for (NACE_Categories category : NACE_Categories.values()) {
            occurrences.put(category, categoryBag.getCount(category));
        }
        Integer maximumValueOfCategoryOccurrence = Collections.max(occurrences.values());
        List<NACE_Categories> selectedCategories = new ArrayList();
        for (Map.Entry<NACE_Categories, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() == maximumValueOfCategoryOccurrence) {
                selectedCategories.add(entry.getKey());
            }
        }
        if (!selectedCategories.isEmpty()) {
            Collections.sort(selectedCategories);
            return selectedCategories;
        }
        return Arrays.asList(NACE_Categories.NOT_CLASSIFIED);
    }

    private Bag listOfCategoriesWhichOccurredInName(String name) {
        Bag categoryOccurrencesInName = new HashBag();
        String[] splitNames = name.split(NON_WORD_DELIMITER);
        if (splitNames == null || splitNames.length == NO_WORDS_TO_ANALYZE)
            return new HashBag(Arrays.asList(NACE_Categories.NOT_CLASSIFIED));
        for (String splitName : splitNames) {
            categoryOccurrencesInName.add(NACE_Categories.retrunCategoryIfFirstEncounteredContains(splitName));
        }
        return categoryOccurrencesInName;
    }

    @Override
    public List classify(DataModel model) {
        return naiveClassify(model);
    }
}
