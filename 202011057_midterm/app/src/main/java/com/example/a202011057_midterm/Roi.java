
package com.example.a202011057_midterm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Roi {

    @SerializedName("times")
    @Expose
    private Double times;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("percentage")
    @Expose
    private Double percentage;

    public Double getTimes() {
        return times;
    }

    public void setTimes(Double times) {
        this.times = times;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

}