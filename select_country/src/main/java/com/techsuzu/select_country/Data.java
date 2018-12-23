package com.techsuzu.select_country;

import android.graphics.Bitmap;

public class Data {
    private String country;
    private String countryCode;
    private String dialingCode;
    private Bitmap flag;

    Data(String country, String countryCode, String dialingCode, Bitmap flag) {
        this.country = country;
        this.countryCode = countryCode;
        this.dialingCode = dialingCode;
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDialingCode() {
        return dialingCode;
    }

    public Bitmap getFlag() {
        return flag;
    }
}