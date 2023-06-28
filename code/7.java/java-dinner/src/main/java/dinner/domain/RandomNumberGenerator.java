package dinner.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 3;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
