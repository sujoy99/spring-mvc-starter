package com.starter.enums;

public enum Status {

    PENDING("Pending");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
