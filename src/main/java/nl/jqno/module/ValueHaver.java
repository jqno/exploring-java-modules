package nl.jqno.module;

import nl.jqno.module.internal.Value;

import java.util.Objects;

public final class ValueHaver {
    private final Value v;

    public ValueHaver(String s) {
        this.v = new Value(s);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ValueHaver other && Objects.equals(v, other.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}
