package dinner.view;

import dinner.domain.Categories;
import dinner.domain.MemberRepository;
import dinner.domain.MenuRecommendationResult;
import dinner.domain.Rank;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {

    private static final String START_MESSAGE = "회식 저녁 메뉴 추천을 시작합니다.\n";

    private static final String MEMBER_NAME = "팀원의 이름을 모두 입력해 주세요. (,로 구분)";

    private static final String LIKE_MENU = "%s(이)가 좋아하는 메뉴를 입력해 주세요.";

    private static final String INPUT_DINNER_MONEY = "회식비를 입력해 주세요";

    private static final String SELECT_DINNER_MONEY = "회식비를 n빵 하실건가요? 몰빵 하실건가요?(1번: n빵, 2번: 몰빵 / 번호만 입력)";

    private static final String RESULT_MENU = "회식 저녁 메뉴 추천 결과입니다.\n";

    private static final String RESULT_MONEY = "회식비 결과 입니다.";

    private static final String END = "\n이제 회식하러 갑시다!";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputMemberName() {
        System.out.println(MEMBER_NAME);
    }

    public static void printInputLikeMenu(String name) {
        System.out.println(String.format(LIKE_MENU, name));
    }

    public static void printEndMessage() {
        System.out.println(END);
    }

    public static void printRecommendationResult(MenuRecommendationResult menuRecommendationResult) {
        System.out.println(RESULT_MENU);
        printRanks();
        printCategories(menuRecommendationResult);
        printResult(menuRecommendationResult);
    }

    public static void printSuccessMessage() {
        System.out.println(END);
    }

    private static void printRanks() {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
//        sj.add("구분");
        for (Rank rank : Rank.values()) {
            sj.add(rank.getName());
        }
        System.out.println(sj.toString());
    }

    private static void printCategories(MenuRecommendationResult menuRecommendationResult) {
        Map<Rank, Categories> result = menuRecommendationResult.getCategoriesResult();
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");

//        sj.add("카테고리");
        for (Rank rank : Rank.values()) {
            sj.add(result.get(rank).getName());
        }
        System.out.println(sj.toString());
    }

    private static void printResult(MenuRecommendationResult menuRecommendationResult) {
        List<String> memberNames = MemberRepository.getMemberNames();
        Map<String, Map<Rank, String>> result = menuRecommendationResult.getRecommendationResult();

        for (int i = 0; i < memberNames.size(); i++) {
            StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
//            sj.add(memberNames.get(i));
            for (Rank rank : Rank.values()) {
                sj.add(result.get(memberNames.get(i)).get(rank));
            }
            System.out.println(sj.toString());
        }
    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}
