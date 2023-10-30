package nl.jqno.module;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.module.internal.Value;

import org.junit.jupiter.api.Test;

public class ClassTest {
    @Test
    void point() {
        EqualsVerifier.forClass(Point.class).verify();
    }

    @Test
    void valueHaverPlain() {
        EqualsVerifier.forClass(ValueHaver.class).verify();
    }

    @Test
    void valueHaverPrefab() {
        EqualsVerifier.forClass(ValueHaver.class)
            .withPrefabValues(Value.class, new Value("a"), new Value("b"))
            .verify();
    }

    @Test
    void value() {
        EqualsVerifier.forClass(Value.class).verify();
    }
}
