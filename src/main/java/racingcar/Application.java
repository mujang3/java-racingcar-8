package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try { new GameController().run(); }
        catch (IllegalArgumentException e) { /* 조용히 종료 */ }
    }
}
