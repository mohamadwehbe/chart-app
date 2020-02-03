package com.example.lenovo.chartdemo;
//creatinine(0.9-1.3 mg/dl) potassium(3.5-5.3 mmol/l) albumin(0-2 mg/dl)
public class report {
    String test;
    double quantity;

    public report(String test, double quantity) {
        this.test = test;
        this.quantity = quantity;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
