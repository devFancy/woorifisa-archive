package dinner.controller;

import dinner.domain.MemberRepository;
import dinner.domain.MenuRecommendationResult;
import dinner.domain.Rank;
import dinner.view.InputView;
import dinner.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static dinner.util.TransformInput.splitInput;

public class MenuController {

    private final MenuRecommendationResult menuRecommendationResult = new MenuRecommendationResult();

    public void run() {
        setup();
        selectCategory();
        recommendRankMenu();

        OutputView.printRecommendationResult(menuRecommendationResult);
        OutputView.printSuccessMessage();
    }

    private void selectCategory() {
        for (Rank rank : Rank.values()) {
            menuRecommendationResult.selectDayCategory(rank);
        }
    }

    private void recommendRankMenu() {
        for (Rank rank : Rank.values()) {
            recommendationMenu(rank);
        }
    }

    private void recommendationMenu(Rank rank) {
        for (String memberName : MemberRepository.getMemberNames()) {
            menuRecommendationResult.menuRecommend(rank, memberName);
        }
    }

    private void initLikeMenu() {
        List<String> names = MemberRepository.getMemberNames();
        for (String name : names) {
            String menu = InputView.readLikeMenu(name);
            MemberRepository.likeMenuRegistration(name, splitInput(menu));
        }
    }

    private void setup() {
        MemberRepository.nameRegistration(initMemberNames());
        initLikeMenu();
    }

    private List<String> initMemberNames() {
        String names = repeat(InputView::readMemberName);
        return splitInput(names);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
