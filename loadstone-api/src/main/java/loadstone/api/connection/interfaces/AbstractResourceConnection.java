package loadstone.api.connection.interfaces;

import loadstone.model.DataModel;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 31.05.15.
 */
public interface AbstractResourceConnection {

    public List<DataModel> returnResourceCollection(List<String> sqlPatternsForLike) throws NoSuchElementException;
    public DataModel returnResource(String resourceIdentifier) throws NoSuchElementException;

}
