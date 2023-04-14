module com.eceshopping {
    requires javafx.controls;
    requires javafx.media;
    requires javafx.swing;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires jakarta.el;
    
    requires bcrypt;
    requires org.flywaydb.core;
    requires javafaker;
    
    opens com.eceshopping.models;
    opens db.migration;
    opens images;

    exports com.eceshopping;
}
