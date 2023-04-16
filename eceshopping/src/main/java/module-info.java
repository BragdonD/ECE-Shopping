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
    // opens db.migration.sqlite;
    opens db.migration.mysql;
    opens images;

    exports com.eceshopping;
    exports com.eceshopping.controllers;
    exports com.eceshopping.converter;
    exports com.eceshopping.daos;
    exports com.eceshopping.dto;
    exports com.eceshopping.events;
    exports com.eceshopping.factories;
    exports com.eceshopping.models;
    exports com.eceshopping.services;
    exports com.eceshopping.utils;
    exports com.eceshopping.views;
}
