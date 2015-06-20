package loadstone.benchmark;

import loadstone.api.classification.loadstone.LoadstonePreprocessing;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import org.openjdk.jmh.annotations.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.06.15.
 */
@State(Scope.Thread)
public class PreprocessingBenchmark {

    private ArrayList patterns;

    public PreprocessingBenchmark() {

        patterns = new ArrayList();
        patterns.add("ul");
        patterns.add("adres");
        patterns.add("\\.");

    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void preprocessWholeDataBaseLoadstoneFromUl() throws SQLException, NoSuchFieldException, ClassNotFoundException {

        LoadstonePreprocessing preprocessing = new LoadstonePreprocessing(patterns);
        DataModel dataModel = new LoadstoneTotalDataObjectModel();
        dataModel.setName("adres ul ul. fake name to be trimmed ");
        DataModel preprocessedLoadstoneDataModel = preprocessing.preprocessDataModel(dataModel);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void preprocessLoadstoneDataModelCollection() throws SQLException, NoSuchFieldException, ClassNotFoundException {
        LoadstonePreprocessing preprocessing = new LoadstonePreprocessing(patterns);
        DataModel dataModelOld = new LoadstoneTotalDataObjectModel();
        dataModelOld.setName("adres ul. czechy 246");
        DataModel dataModelOld_1 = new LoadstoneTotalDataObjectModel();
        dataModelOld_1.setName("adres ul. kramarska 15 warszawa rembertów");
        ArrayList<DataModel> dataModelsOld = new ArrayList<DataModel>();
        dataModelsOld.add(dataModelOld);
        dataModelsOld.add(dataModelOld_1);
        DataModel dataModelNew = new LoadstoneTotalDataObjectModel();
        dataModelNew.setName("czechy 246");
        DataModel dataModelNew_1 = new LoadstoneTotalDataObjectModel();
        dataModelNew_1.setName("kramarska 15 warszawa rembertów");

        List preprocessedCollection = preprocessing.preprocessCollection(dataModelsOld);
        preprocessedCollection.get(0);
    }
}
