package nl.jqno.module;

import static nl.jqno.module.Helper.*;

import java.text.AttributedString;
import java.util.Objects;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

public class JdkTest {
    @Test
    void jdkClassHaver() {
        assertDependencyIsInaccessible(
            AttributedString.class,
            () -> EqualsVerifier.forClass(JdkClassHaver.class).verify());
    }

    @Test
    void jdkClass() {
        assertSutIsInaccessible(
            () -> EqualsVerifier
                    .forClass(AttributedString.class)
                    .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                    .verify());
    }

    static final class JdkClassHaver {
        private final AttributedString d;

        public JdkClassHaver(AttributedString d) {
            this.d = d;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof JdkClassHaver other && Objects.equals(d, other.d);
        }

        @Override
        public int hashCode() {
            return Objects.hash(d);
        }
    }
}
