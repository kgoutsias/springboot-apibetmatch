package net.javaguides.springbootapibetmatch.model;
public enum Sport {
    Football(1),
    Basketball(2);

    public final int ordinal;

    Sport(int ordinal) {
        this.ordinal = ordinal;
    }
    public int getOrdinal() {
        return ordinal;
    }

}
