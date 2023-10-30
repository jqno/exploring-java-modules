package nl.jqno.module.internal;

import java.util.Objects;

public final class Value {
    private final String s;

    public Value(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Value other && Objects.equals(s, other.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
