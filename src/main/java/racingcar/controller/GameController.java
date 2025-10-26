package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomMovePolicy;
import racingcar.support.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public void run() {
        String namesLine = InputView.readCarNames();
        List<String> names = Validator.parseAndValidateNames(namesLine);
        String attemptLine = InputView.readAttemptCount();
        int attempts = Validator.parseAndValidateAttempts(attemptLine);

        Cars cars = Cars.of(names);
        OutputView.printExecuteTitle();
        for (int i = 0; i < attempts; i++) {
            cars.moveAll(new RandomMovePolicy());
            OutputView.printRound(cars.snapshot());
        }
        OutputView.printWinners(cars.winners());
    }
}
