package loadstone.api;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 26.04.15.
 */
public class LoadstoneAPIUtils {
    private static final String COLUMN_TO_PREPROCESS_NAME = "name";

    public static String prepareSqlQuery(List<String> patterns) {
        StringBuilder builder = new StringBuilder();
        for (String pattern : patterns) {
            if (patterns.indexOf(pattern) == patterns.size() - 1)
                builder.append(COLUMN_TO_PREPROCESS_NAME).append(" LIKE ").append("\'%").append(pattern).append("%\'");
            else
                builder.append(COLUMN_TO_PREPROCESS_NAME).append(" LIKE ").append("\'%").append(pattern).append("%\'").append(" OR ");
        }
        return builder.toString();
    }
}
