package loadstone.api.connection.loadstone;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import loadstone.model.database.LoadstoneDatabaseModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 03.06.15.
 */
public class LoadstoneDatabaseUpdater {

    private static LoadstoneDatabaseModel model;
    private LoadstoneDatabaseUpdater(){

    }
    /**
     * Returns database with default name loadStoneDataBase.db
     *
     * @return LoadstoneDatabaseModel
     * @throws NoSuchFieldException
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */

    public static ObjectModel<LoadstoneTotalDataObjectModel, ResultSet, HashMap<String, Object>> getObjectModelSingleton()
            throws NoSuchFieldException, SQLException, ClassNotFoundException {
        model=new LoadstoneDatabaseModel();
        return model.getObjectModel(LoadstoneTotalDataObjectModel.class);
    }


}
