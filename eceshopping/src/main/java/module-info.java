module com.eceshopping {
    requires javafx.controls;
    requires javafx.media;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires jakarta.el;
    requires org.flywaydb.core;
    exports com.eceshopping;
    opens com.eceshopping.models;
}
