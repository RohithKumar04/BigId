import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PagePartitioner {

    private final static Logger LOGGER =
            Logger.getLogger(PagePartitioner.class.getName());

    private static List<String> partitionBySize(List<String> lines,int batchSize){

        if(batchSize < 0) {
            throw new RuntimeException("BatchSize cannot be less than 0");
        }

        int totalBatches = (lines.size() - 1) / batchSize;
        LOGGER.info(String.format("Splitting %d lines into %d batches", lines.size(), totalBatches));

        List<String> parts = IntStream.rangeClosed(0,totalBatches)
                .mapToObj(batch -> {
                    int startIndex=batch * batchSize;
                    int endIndex=(batch == totalBatches) ? lines.size() : (batch + 1) * batchSize;
                    return String.join("",lines.subList(startIndex,endIndex));
                }).collect(Collectors.toList());

        return parts;

    }

    public static List<String> fetchFileInPages(String fileName, int linesPerPage) {

        List<String> pages=null;
        //Fetch the text
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while (br.ready()) {
                List<String> a=br.lines().collect(Collectors.toList());
                pages = partitionBySize(a, linesPerPage);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pages;
    }
}
