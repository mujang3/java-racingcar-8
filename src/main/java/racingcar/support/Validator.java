package racingcar.support;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> parseAndValidateNames(String raw){
        if (raw == null || raw.isBlank()) throw new IllegalArgumentException("이름 입력이 비어 있습니다.");
        String[] tokens = raw.split(",");
        List<String> names = new ArrayList<>();
        for (String t: tokens){
            String name = t.trim();
            if (name.isEmpty()) throw new IllegalArgumentException("이름에 빈 항목이 있습니다.");
            names.add(name);
        }
        return names;
    }

    public static int parseAndValidateAttempts(String raw){
        if (raw == null || raw.isBlank()) throw new IllegalArgumentException("시도 횟수 입력이 비어 있습니다.");
        if (!raw.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        int n = Integer.parseInt(raw);
        if (n <= 0) throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        return n;
    }
}
