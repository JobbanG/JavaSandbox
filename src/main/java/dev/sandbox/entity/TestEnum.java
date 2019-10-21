package dev.sandbox.entity;

public enum TestEnum {

    FIRST_VALUE ("first.value"),
    SECOND_VALUE("second.value"),
    THIRD_VALUE("third.value");

    private String messageCode;

    TestEnum(String messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public String toString() {
        return messageCode;
    }

}
