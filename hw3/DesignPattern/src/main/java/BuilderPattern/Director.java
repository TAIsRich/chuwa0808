package BuilderPattern;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Phone construct() {
        builder.buildchip();
        builder.buildbackCover();
        builder.buildscreen();
        return builder.getPhone();
    }
}