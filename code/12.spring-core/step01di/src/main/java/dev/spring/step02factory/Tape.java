package dev.spring.step02factory;

public class Tape {
    String name;    // 테이프 이름
    boolean isWorked;   // 테이프가 정상 동작하는지

    public Tape(String name, boolean isWorked) {
        this.name = name;
        this.isWorked = isWorked;
    }

    public String getName() {
        return name;
    }

    public boolean isWorked() {
        return isWorked;
    }
}
