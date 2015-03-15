package loadstone.model.database;

import loadstone.model.object.TotalData;
import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoadstoneDatabaseModel extends
        DatabaseModel<ResultSet, HashMap<String, Object>> {

    public LoadstoneDatabaseModel() throws SQLException, ClassNotFoundException,
            NoSuchFieldException {
        super((Object[]) null);
    }

    /*
 * (non-Javadoc)
 *
 * @see
 * za.co.neilson.sqlite.orm.DatabaseModel#onInitializeDatabaseDriverInterface
 * ()
 */
    @Override
    protected DatabaseDriverInterface<ResultSet, HashMap<String, Object>> onInitializeDatabaseDriverInterface(
            Object... args) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see za.co.neilson.sqlite.orm.DatabaseModel#onCreateDatabaseInfoModel()
     */
    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel()
            throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {
        };
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * za.co.neilson.sqlite.orm.DatabaseModel#onRegisterObjectModels(java.util
     * .HashMap)
     */
    @Override
    protected void onRegisterObjectModels(
            HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> objectModels)
            throws ClassNotFoundException, NoSuchFieldException {
        /*
         * Tables Managed By This Model
		 */
        // Register the ObjectModel for the Car class with the DatabaseModel
        objectModels.put(TotalData.class, new JdbcObjectModel<TotalData>(this) {
        });
    }

    /*
     * (non-Javadoc)
     *
     * @see za.co.neilson.sqlite.orm.DatabaseModel#getDatabaseName()
     */

    @Override
    public String getDatabaseName() {
        return "loadStoneDataBase.db";
    }

    /*
     * (non-Javadoc)
     *
     * @see za.co.neilson.sqlite.orm.DatabaseModel#getDatabaseVersion()
     */
    @Override
    public int getDatabaseVersion() {
        return 1;
    }

    /*
     * (non-Javadoc)
     *
     * @see za.co.neilson.sqlite.orm.DatabaseModel#onCreate()
     */
    @Override
    protected void onCreate() throws SQLException {
        super.onCreate();
    }

    ;

    /*
     * (non-Javadoc)
     *
     * @see za.co.neilson.sqlite.orm.DatabaseModel#onUpgrade(int)
     */
    @Override
    protected void onUpgrade(int previousVersion) throws SQLException {
        super.onUpgrade(previousVersion);
    }

    ;

    /*
     * (non-Javadoc)
     *
     * @see za.co.neilson.sqlite.orm.DatabaseModel#onInsertDefaultValues()
     */
    @Override
    protected void onInsertDefaultValues() {

    }
}