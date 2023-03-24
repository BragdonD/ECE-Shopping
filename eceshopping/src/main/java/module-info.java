module com.eceshopping {
    requires javafx.controls;
    requires javafx.media;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires jakarta.el;
    requires bcrypt;
    requires org.flywaydb.core;
    exports com.eceshopping;
    opens db.migration;
}
