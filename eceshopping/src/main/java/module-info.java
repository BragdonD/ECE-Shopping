module com.eceshopping {
    requires javafx.controls;
    requires javafx.media;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires jakarta.el;
    requires org.flywaydb.core;
    requires javafaker;
    requires bcrypt;
    
    opens com.eceshopping.models;
    opens db.migration;
    opens images;

    exports com.eceshopping;
}
