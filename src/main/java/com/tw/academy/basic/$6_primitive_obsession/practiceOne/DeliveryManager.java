package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    Address toAddress;
    Address fromAddress;

    public DeliveryManager(String fromAddress, String toAddress) {
        this.toAddress = new Address(toAddress.substring(toAddress.indexOf("省") + 1, toAddress.indexOf("市")), toAddress.substring(0, toAddress.indexOf("省")));
        this.fromAddress = new Address(fromAddress.substring(fromAddress.indexOf("省") + 1, fromAddress.indexOf("市")), fromAddress.substring(0, fromAddress.indexOf("省")));
    }

    public DeliverCenter allocate(){
        if (toAddress.getProvince().equals(fromAddress.getProvince()) && toAddress.getCity().equals(fromAddress.getCity())){
            return DeliverCenter.LOCAL;
        }
        if (toAddress.getProvince().equals(fromAddress.getProvince())) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

}
