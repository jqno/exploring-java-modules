module nl.jqno.module {
    exports nl.jqno.module;
    exports nl.jqno.module.recordinternal;
    opens nl.jqno.module;

    requires org.junit.jupiter.api;
    requires nl.jqno.equalsverifier;
    requires net.bytebuddy;
}
