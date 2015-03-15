package loadstone.api;

import loadstone.model.database.LoadstoneDatabaseModel;
import loadstone.model.object.TotalData;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Szymon.Lyszkowski@gmail.com on 08.02.15.
 */

public class demo {

    @Test
    public void demo() {

        try {
            //Get a DatabaseModel instance
            LoadstoneDatabaseModel carDatabaseModel = new LoadstoneDatabaseModel();

            // Use the DatabaseModel to get the ObjectModel for the Car class
            List<TotalData> cars = carDatabaseModel.getObjectModel(TotalData.class).getAll();
            //Display the results
            for (TotalData car : cars) {
                if (StringUtils.contains(car.getName(), " bank ")) {
                    System.out.println(car.getName());
                }

            }

        } catch (ClassNotFoundException | NoSuchFieldException | SQLException e) {
            e.printStackTrace();
        }

    }
}


