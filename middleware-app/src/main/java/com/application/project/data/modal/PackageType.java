package com.application.project.data.modal;

public enum PackageType {
    PIECE("Piece"), WIGHT("Weight");

    public final String value;

    private PackageType(String description) {
        value = description;

    }
}
