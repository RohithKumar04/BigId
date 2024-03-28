import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Constants {

    private static final String NAMES = "James,John,Robert,Michael,William,David,Richard,Charles,Joseph,Thomas,Christopher,Daniel,Paul,Mark,Donal d,George,Kenneth,Steven,Edward,Brian,Ronald,Anthony,Kevin,Jason,Matthew,Gary,Timothy,Jose,Larry,Jeffrey,Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory,Joshua,Jerry,Dennis,Walter,Patrick,Peter,Harold,Douglas,Henry,Carl,Arthur,Ryan,Roger";
    public static final int LINES_PER_BATCH = 1000;


    public static List<String> getFirstNamesList() {
        return Arrays.stream(NAMES.split(","))
                .collect(Collectors.toList());

    }
}
