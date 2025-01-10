package nl.jqno.module;

import static nl.jqno.module.Helper.*;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.module.recordinternal.RecordValue;
import org.junit.jupiter.api.Test;

public class RecordTest {
    @Test
    void point() {
        EqualsVerifier.forClass(RecordPoint.class).verify();
    }

    @Test
    void valueHaverPlain() {
        assertDependencyIsInaccessible(
            RecordValue.class,
            () -> EqualsVerifier.forClass(RecordValueHaver.class).verify());
    }

    @Test
    void valueHaverPrefab() {
        EqualsVerifier
                .forClass(RecordValueHaver.class)
                .withPrefabValues(RecordValue.class, new RecordValue("a"), new RecordValue("b"))
                .verify();
    }

    @Test
    void value() {
        assertSutIsInaccessible(() -> EqualsVerifier.forClass(RecordValue.class).verify());
    }
}
