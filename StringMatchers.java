import java.util.ArrayList;
import java.util.List;

public class StringMatchers {


    public static List<NameCoordinates> fetchStringMatchers(String page, List<String> stringsToSearch, int lineOffset) {

        List<NameCoordinates> matches = new ArrayList<>();

        stringsToSearch.forEach((s) -> matches.addAll(getCoordinatesOfString(s, page, lineOffset)));
        return matches;
    }
    
    private static List<NameCoordinates> getCoordinatesOfString(String name,String page,int lineOffset) {

        List<NameCoordinates> result = new ArrayList<>();

        int index=page.indexOf(name);
        while (index != -1) {
            result.add(new NameCoordinates(lineOffset, index, name));
            index = page.indexOf(name, index + 1);
        }

        return result;
    }
}
