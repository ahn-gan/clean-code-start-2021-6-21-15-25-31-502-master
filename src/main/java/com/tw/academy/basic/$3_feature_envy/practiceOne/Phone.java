package com.tw.academy.basic.$3_feature_envy.practiceOne;

public class Phone {

    private String areaCode;

    private String prefix;

    private String number;

    public Phone(String unformattedNumber) {
        this.areaCode = unformattedNumber.substring(0,3);
        this.prefix = unformattedNumber.substring(3,6);
        this.number = unformattedNumber.substring(6,10);
    }

    public String getMobilePhoneNumber() {
        return "(" +
                areaCode + ") " +
                prefix + "-" +
                number;
    }
}
