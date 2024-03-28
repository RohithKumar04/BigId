import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    public static void searchStringsInText(String filePath, List<String> stringsToSearch ) {

        long start=System.currentTimeMillis();

        // PARTITIONER - partition txt into pages
        List<String> pages=PagePartitioner.fetchFileInPages(filePath,Constants.LINES_PER_BATCH);

        // MATCHER - Fetch string co-ordinates in each page by parallel processing
        List<List<NameCoordinates>> allMatchers = Executor.execute(pages, stringsToSearch, Constants.LINES_PER_BATCH);

        // AGGREGATOR - Combine the results together
        Map<String, Set<Coordinates>> finalMatchers=allMatchers.stream()
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(
                                NameCoordinates::getName,
                                Collectors.mapping(NameCoordinates::getCoordinates,Collectors.toSet())
                        )
                );

        long end=System.currentTimeMillis();
        System.out.println(finalMatchers);
        System.out.println("Total Time taken: " + (end - start) + "ms");

    }

    public static void main(String[] args) {

        Main.searchStringsInText("BigID.txt", Constants.getFirstNamesList());
    }
}
