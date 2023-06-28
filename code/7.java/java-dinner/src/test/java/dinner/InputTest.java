package dinner;

import dinner.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("팀원의 이름은 최소 2글자, 최대 4글자가 아닌 경우 예외 처리한다.")
    @CsvSource({"하", "쉬고싶다", "진심으로쉬고싶다"})
    @ParameterizedTest
    void 팀원의_이름으_최소_2글자_최대_4글자가_아닌경우_예외_처리한다(String string) {
        //given
        InputStream in = generateUserInput(string);
        System.setIn(in);

        //when & then
        assertThatThrownBy(() -> InputView.readMemberName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
