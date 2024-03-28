import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class SearchThread implements Callable<List<NameCoordinates>> {

    private String page;
    private int lineOffset;

    private List<String> stringsToSearch;

    public SearchThread(String page,List<String> stringsToSearch, int lineOffset) {
        this.page=page;
        this.lineOffset=lineOffset;
        this.stringsToSearch=stringsToSearch;
    }

    @Override
    public List<NameCoordinates> call() {
        return StringMatchers.fetchStringMatchers(page, stringsToSearch, lineOffset);
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page=page;
    }

    public int getLineOffset() {
        return lineOffset;
    }

    public void setLineOffset(int lineOffset) {
        this.lineOffset=lineOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchThread that=(SearchThread) o;
        return lineOffset == that.lineOffset && Objects.equals(page,that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page,lineOffset);
    }
}
