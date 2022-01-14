package ro.fasttrackit.curs13.homework12;

import java.util.Objects;

public class KmRange {
    private final int min;
    private final int max;

    public KmRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean matches(int km) {
        return km >= min && km < max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KmRange kmRange = (KmRange) o;
        return min == kmRange.min && max == kmRange.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return "KmRange{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
