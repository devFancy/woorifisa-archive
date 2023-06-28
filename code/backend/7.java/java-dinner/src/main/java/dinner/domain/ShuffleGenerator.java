package dinner.domain;

import java.util.List;

public interface ShuffleGenerator {
    List<String> generate(List<String> menus);
}
