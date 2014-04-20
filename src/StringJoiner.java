import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by evazamudio on 2014-04-20.
 */
public class StringJoiner {
    private String delimiter;

    public StringJoiner(String delimiter) {
        this.delimiter = delimiter;
    }

    public String join(ArrayList<String> strings) {
        if (!strings.isEmpty()){
            String firstString = strings.get(0);
            ArrayList<String> remainingStrings =
                    (ArrayList<String>) strings.subList(1, strings.size());
            return firstString +
                    concatenateWithDelimiter(strings);
        }
        return "";
    }

    private String concatenateWithDelimiter(ArrayList<String> strings) {
        String result = "";
        for (String string : strings) {
            result += delimiter + string;
        }
        return result;
    }
}


