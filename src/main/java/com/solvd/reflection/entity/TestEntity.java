package com.solvd.reflection.entity;


public class TestEntity {
    private String textField;
    private int numericField;
    private double numericDecimalField;

    public TestEntity() {

    }

    public TestEntity(String textField, int numericField, double numericDecimalField) {
        this.textField = textField;
        this.numericField = numericField;
        this.numericDecimalField = numericDecimalField;
    }

    private String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public int getNumericField() {
        return numericField;
    }

    public void setNumericField(int numericField) {
        this.numericField = numericField;
    }

    public double getNumericDecimalField() {
        return numericDecimalField;
    }

    public void setNumericDecimalField(double numericDecimalField) {
        this.numericDecimalField = numericDecimalField;
    }

    public double getNumericFieldSummary() {
        return this.numericField + this.numericDecimalField;
    }

    public String getTextFieldWithNewLine() {
        return this.getTextField() + "\n";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + "textField = " + textField  + ", numericField = " + numericField +
                ", numericDecimalField = " + numericDecimalField + "]";
    }
}
