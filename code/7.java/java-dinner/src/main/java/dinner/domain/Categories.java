package dinner.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public enum Categories {
    JAPAN(1, "일식", Arrays.asList("규동", "우동", "나베", "회", "가츠동", "오니기리", "라멘", "가라아게")),
    KOREA(2, "한식", Arrays.asList("김치찌개", "된장찌개", "감자탕", "삼겹살", "불고기", "떡볶이", "파전", "연포탕")),
    CHINA(3, "중식", Arrays.asList("깐풍기", "훠궈", "마라탕", "짜장면", "짬뽕", "마파두부", "탕수육", "양꼬치"));

    private final int index;
    private final String name;
    private final List<String> menuNames;

    Categories(int index, String name, List<String> menuNames) {
        this.index = index;
        this.name = name;
        this.menuNames = menuNames;
    }

    public static Categories getCategoryBYIndex(int index) {
        Categories type = null;
        for (Categories category : Categories.values()) {
            if (category.getIndex() == index) type = category;
        }
        return type;
    }

    public static String getShuffledMenu(Categories categories) {
        ShuffleGeneratorImpl shuffleGenerator = new ShuffleGeneratorImpl();
        List<String> menus = categories.getMenuNames();
        String menu = shuffleGenerator.generate(menus).get(0);
        return menu;
    }

    public int getIndex() {
        return index;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public String getName() {
        return name;
    }
}
