package loadstone.api.connection.loadstone;

import loadstone.api.connection.interfaces.AbstractResourceConnection;
import loadstone.api.utils.LoadstoneAPIUtils;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for loadstone database access
 */
public class LoadstoneDatabase implements AbstractResourceConnection {

    @Override
    public List<DataModel> returnResourceCollection(List<String> sqlPatternsForLike) throws NoSuchElementException {
        ObjectModel<LoadstoneTotalDataObjectModel, ResultSet, HashMap<String, Object>> objectModelSingleton = null;
        try {
            objectModelSingleton = LoadstoneDatabaseUpdater.getObjectModelSingleton();
            List<LoadstoneTotalDataObjectModel> allFromDB = objectModelSingleton.getAll(LoadstoneAPIUtils.prepareSqlQuery(sqlPatternsForLike));
            List<DataModel> workingCollection = new ArrayList<>();
            workingCollection.addAll(allFromDB);
            if (workingCollection.isEmpty())
                throw new NoSuchElementException();
            return workingCollection;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public DataModel returnResource(String dataRowNumber) throws NoSuchElementException {

        try {
            ObjectModel<LoadstoneTotalDataObjectModel, ResultSet, HashMap<String, Object>> objectModelSingleton = LoadstoneDatabaseUpdater
                    .getObjectModelSingleton();
            LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel = objectModelSingleton.getAll().get(Integer.parseInt(dataRowNumber));
            if (loadstoneTotalDataObjectModel == null)
                throw new NoSuchElementException();
            return loadstoneTotalDataObjectModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
