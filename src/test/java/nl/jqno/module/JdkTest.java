package nl.jqno.module;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Test;

import java.text.AttributedString;
import java.util.Objects;

public class JdkTest {
    @Test
    void jdkClassHaver() {
        EqualsVerifier.forClass(JdkClassHaver.class).verify();
    }

    @Test
    void jdkClass() {
        EqualsVerifier.forClass(AttributedString.class).verify();
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
