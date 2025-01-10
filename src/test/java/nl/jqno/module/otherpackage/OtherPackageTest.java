package nl.jqno.module.otherpackage;

import static nl.jqno.module.Helper.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.module.Point;
import nl.jqno.module.ValueHaver;
import nl.jqno.module.internal.Value;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("The package this test is in needs to be 'opens'ed in module-info for these tests to work!")
public class OtherPackageTest {
    @Test
    void point() {
        EqualsVerifier.forClass(Point.class).verify();
    }

    @Test
    void valueHaverPlain() {
        assertDependencyIsInaccessible(Value.class, () -> EqualsVerifier.forClass(ValueHaver.class).verify());
    }

    @Test
    void valueHaverPrefab() {
        EqualsVerifier
                .forClass(ValueHaver.class)
                .withPrefabValues(Value.class, new Value("a"), new Value("b"))
                .verify();
    }

    @Test
    void value() {
        assertSutIsInaccessible(() -> EqualsVerifier.forClass(Value.class).verify());
    }
}
