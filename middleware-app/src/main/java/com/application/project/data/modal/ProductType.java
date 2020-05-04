package com.application.project.data.modal;

public enum ProductType {

    VEGETABLE("Vegetable"), FRUITS("fruits");

    public final String value;

    private ProductType(String description) {
        value = description;
    }
}
