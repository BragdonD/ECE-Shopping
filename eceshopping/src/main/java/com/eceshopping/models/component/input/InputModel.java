package com.eceshopping.models.component.input;


/**
 * InputModel class is a model class for the Input component. It contains the
 * attributes of the Input component.
 */
public class InputModel {
    private String label;
    private String type;
    private String name;
    private Boolean isValid;
    private String value;
    private String placeholder;
    private String style;

    public InputModel() {
        this.label = "";
        this.type = "";
        this.name = "";
        this.value = "";
        this.placeholder = "";
        this.isValid = false;
        this.style = "";
    }

    public InputModel(String label, String type, String name, String value, String placeholder, String style) {
        this.label = label;
        this.type = type;
        this.name = name;
        this.value = value;
        this.placeholder = placeholder;
        this.isValid = false;
        this.style = style;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Boolean isValid() {
        return this.isValid;
    }

    public void setValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public InputModel label(String label) {
        setLabel(label);
        return this;
    }

    public InputModel type(String type) {
        setType(type);
        return this;
    }

    public InputModel name(String name) {
        setName(name);
        return this;
    }

    public InputModel value(String value) {
        setValue(value);
        return this;
    }

    public InputModel placeholder(String placeholder) {
        setPlaceholder(placeholder);
        return this;
    }

    public InputModel isValid(Boolean isValid) {
        setValid(isValid);
        return this;
    }

    public InputModel style(String style) {
        setStyle(style);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " label='" + getLabel() + "'" +
                ", type='" + getType() + "'" +
                ", name='" + getName() + "'" +
                ", value='" + getValue() + "'" +
                ", placeholder='" + getPlaceholder() + "'" +
                ", isValid='" + isValid() + "'" +
                ", style='" + getStyle() + "'" +
                "}";
    }

}
