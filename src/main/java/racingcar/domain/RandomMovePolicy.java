package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomMovePolicy implements MovePolicy {
    private static final int THRESHOLD = 4;
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= THRESHOLD;
    }
}
