package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class Address {

    private  String city;

    private  String province;

    public Address(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }
}
