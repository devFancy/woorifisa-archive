package dinner.util;

import java.util.Arrays;
import java.util.List;

public class TransformInput {
    public static List<String> splitInput(String input) {
        String[] transformInput = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        return Arrays.asList(transformInput);
    }
}
