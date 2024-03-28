import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Executor {


    public static List<List<NameCoordinates>> execute(List<String> pages, List<String> stringsToSearch, int linesPerBatch) {

        List<List<NameCoordinates>> res = new ArrayList<>();

        ExecutorService es = Executors.newFixedThreadPool(8);

        List<Future<List<NameCoordinates>>> a=IntStream.range(0,pages.size())
                .mapToObj(i -> es.submit(new SearchThread(pages.get(i), stringsToSearch, linesPerBatch * i)))
                .toList();

        a.forEach(listFuture -> {
            try {
                List<NameCoordinates> s = listFuture.get();
                res.add(s);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        es.shutdown();
        return res;
    }
}
