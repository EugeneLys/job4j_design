package ru.job4j.map;
import java.util.Objects;

public class EffectiveHashCode {

    private int number;
    private int index;
    private String name;

    public EffectiveHashCode(int number, int index, String name) {
        this.number = number;
        this.index = index;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EffectiveHashCode that = (EffectiveHashCode) o;
        return number == that.number && index == that.index && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(number);
        result = (31 * result) + Integer.hashCode(index);
        result = (31 * result) + Objects.hashCode("name");
        return result;
    }
}
