module com.eceshopping {
    requires javafx.controls;
    requires javafx.media;
    requires javafx.swing;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires jakarta.el;
    requires java.sql;
    requires bcrypt;
    requires java.desktop;
    requires org.flywaydb.core;
    requires javafaker;

    exports com.eceshopping;

    opens com.eceshopping.models;

    opens images;
}
