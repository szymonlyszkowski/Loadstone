package loadstone.benchmark;

import loadstone.api.classification.NaiveClassifier;
import loadstone.model.DataModel;
import loadstone.model.object.LoadstoneTotalDataObjectModel;
import loadstone.model.poi.categories.NACE_Categories;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 20.06.15.
 */
public class NaiveClassifierBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void shouldReturnCategoryC(){
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("Manufacturing Manufacturing Manufacturing Manufacturing Manufacturing Manufacturing administration administration administration");
        NaiveClassifier naiveClassifier = new NaiveClassifier();
        List<NACE_Categories> selectedCategory = naiveClassifier.classify(model);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void shouldReturnCategoryA(){
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("Manufacturing Manufacturing Manufacturing administration administration administration");
        NaiveClassifier naiveClassifier = new NaiveClassifier();
        List<NACE_Categories> selectedCategory = naiveClassifier.classify(model);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void shouldReturnCategoryNotClassified(){
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName(" ");
        NaiveClassifier naiveClassifier = new NaiveClassifier();
        List<NACE_Categories> selectedCategory = naiveClassifier.classify(model);;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void shouldReturnNotClassifiedDataFromLoadstone(){
        DataModel model = new LoadstoneTotalDataObjectModel();
        model.setName("bankomat i oddział bz bwk atm 24h bank ul. jana pawła ii 12 sieradz");
        NaiveClassifier naiveClassifier = new NaiveClassifier();
        List<NACE_Categories> selectedCategory = naiveClassifier.classify(model);;
    }
}
