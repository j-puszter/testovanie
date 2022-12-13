package com.example.demo;

public class Address {
    private String streetAddress;
    private String city;
    private String zipCode;
    private String state;

    public Address(String streetAddress, String city, String zipCode, String state) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFormattedAddress() {
        String address = "Ulica: " + streetAddress;
        address += ", Mesto: " + city;
        address += ", PSC: " + zipCode;
        address += ", Stat: " + state;
        return address;
    }
}
