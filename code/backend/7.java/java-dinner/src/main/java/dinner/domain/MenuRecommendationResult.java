package dinner.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendationResult {
    private final Map<String, Map<Rank, String>> recommendationResult = new HashMap();
    private final Map<Rank, Categories> categoriesResult = new HashMap<>();

    public void selectDayCategory(Rank rank) {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        Categories category;
        while (true) {
            int index = randomNumberGenerator.generate();
            category = Categories.getCategoryBYIndex(index);

            if (!validateDuplicateCategory(category)) break;
        }
        categoriesResult.put(rank, category);
    }

    private boolean validateDuplicateCategory(Categories category) {
        int count = 0;
        for (Categories categories : categoriesResult.values()) {
            if (categories.equals(category)) count++;
        }
        return count >= 2;
    }

    public void menuRecommend(Rank rank, String memberName) {
        String shuffledMenu;
        while (true) {
            shuffledMenu = Categories.getShuffledMenu(categoriesResult.get(rank));
            if (validateLikeMenu(memberName, shuffledMenu, categoriesResult.get(rank)) && !validateDuplicateMenu(memberName, shuffledMenu))
                break;
        }
        if (recommendationResult.containsKey(memberName)) {
            recommendationResult.get(memberName).put(rank, shuffledMenu);
            return;
        }
        HashMap<Rank, String> result = new HashMap<>();
        result.put(rank, shuffledMenu);
        recommendationResult.put(memberName, result);
    }

    private boolean validateLikeMenu(String memberName, String shuffledMenu, Categories categories) {
        Map<String, List<String>> memberLikeMenu = MemberRepository.getMemberLikeMenu();
        // 규동,우동을 좋아한다고 했는데, 중식 카테고리랑 비교하게 되면서 무조건 false로 빠진다
        List<String> likeList = memberLikeMenu.get(memberName);
        List<String> foodList = categories.getMenuNames();
        boolean isSameCategory = false;
        for (String likeFoodName : likeList) {
            if (foodList.contains(likeFoodName)) {
                //좋아하는 푸드가 현재 고르고 있는 카테고리와 같으면 true
                isSameCategory = true;
            }
        }
        if (memberLikeMenu.get(memberName).contains(shuffledMenu) || !isSameCategory) {
            //좋아하는 메뉴가 shuffledMenu 과 같거나 , 현재 고르고 있는 카테고리와 다르면 true 반환
            return true;
        }
        return false;
    }

    private boolean validateDuplicateMenu(String memberName, String shuffledMenu) {
        //Map<Rank, String> result = recommendationResult.get(memberName);
        if (recommendationResult.get(memberName) == null) {
            return false;
        }
        Map<Rank, String> result = recommendationResult.get(memberName);
        return result.containsValue(shuffledMenu);
    }

    public Map<String, Map<Rank, String>> getRecommendationResult() {
        return recommendationResult;
    }

    public Map<Rank, Categories> getCategoriesResult() {
        return categoriesResult;
    }

    @Override
    public String toString() {
        return "MenuRecommendationResult{" +
                "recommendationResult=" + recommendationResult +
                '}' +
                "MenuRecommendationResult{" +
                "categoriesResult=" + categoriesResult +
                '}'
                ;
    }
}
