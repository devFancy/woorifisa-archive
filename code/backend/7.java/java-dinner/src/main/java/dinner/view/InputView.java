package dinner.view;

import camp.nextstep.edu.missionutils.Console;

import static dinner.util.InputValidate.*;

public class InputView {

    public static String readMemberName() {
        OutputView.printStartMessage();
        OutputView.printInputMemberName();

        String MemberName = Console.readLine();
        validateNameLength(MemberName);
        validateNamesSize(MemberName);
        return MemberName;
    }

    public static String readLikeMenu(String name) {
        OutputView.printInputLikeMenu(name);

        String hateMenu = Console.readLine();
        validateMenuSize(hateMenu);
        if (!hateMenu.equals("")) validateInvalidMenu(hateMenu);
        return hateMenu;
    }
}
