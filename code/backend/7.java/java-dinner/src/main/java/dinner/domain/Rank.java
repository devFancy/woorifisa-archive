package dinner.domain;

public enum Rank {
    ONE("1순위"),
    TWO("2순위"),
    THREE("3순위");

    private String name;

    Rank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
