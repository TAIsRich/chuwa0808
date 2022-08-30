package BuilderPattern;

public abstract  class Builder {
    protected Phone phone = new Phone();

    public abstract void buildchip();
    public abstract void buildbackCover();
    public abstract void buildscreen();
    public abstract Phone getPhone();

}