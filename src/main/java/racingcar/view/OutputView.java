package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public static void printExecuteTitle(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRound(List<String> lines){
        for (String line : lines) System.out.println(line);
        System.out.println();
    }

    public static void printWinners(List<String> winners){
        StringJoiner joiner = new StringJoiner(", ");
        winners.forEach(joiner::add);
        System.out.println("최종 우승자 : " + joiner);
    }
}
