package nl.jqno.module;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Helper {
    public static void assertDependencyIsInaccessible(Class<?> t, Runnable r) {
        var throwable = assertThrows(AssertionError.class, () -> r.run());
        assertTrue(
            throwable.getMessage().contains("type " + t.getName() + " is not accessible via the Java Module System"));
    }

    public static void assertSutIsInaccessible(Runnable r) {
        var throwable = assertThrows(AssertionError.class, () -> r.run());
        assertTrue(throwable.getMessage().contains("The class is not accessible via the Java Module system"));
    }
}
