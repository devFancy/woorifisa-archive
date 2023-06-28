package dinner.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static final List<String> memberNames = new ArrayList<>();

    private static final Map<String, List<String>> memberLikeMenu = new HashMap<>();

    public static void nameRegistration(List<String> names) {
        memberNames.addAll(names);
    }

    public static void likeMenuRegistration(String name, List<String> menu) {
        memberLikeMenu.put(name, menu);
    }

    public static List<String> getMemberNames() {
        return memberNames;
    }

    public static Map<String, List<String>> getMemberLikeMenu() {
        return memberLikeMenu;
    }
}
