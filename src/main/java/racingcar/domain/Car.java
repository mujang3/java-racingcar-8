package racingcar.domain;

final class Car {
    private static final int NAME_MAX = 5;
    private final String name;
    private int position = 0;

    Car(String name){
        if(name == null || name.isBlank()) throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        if (name.length() > NAME_MAX) throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        this.name = name;
    }
    void moveIf(MovePolicy policy) {if (policy.canMove()) position++;}
    String name() {return name;}
    int position() {return position;}
    String progressBar() {return "-".repeat(position);}
}
