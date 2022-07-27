package com.example.giaphong.DTO;

import javax.validation.constraints.*;


public class SimpleUser {
    @NotNull
    @NotEmpty(message = "Tên không được bỏ trống")
    private String name;

    @NotEmpty(message = "Địa chỉ không được bỏ trống")
    private String address;

    @Pattern(regexp = "^0\\d{9}$", message = "Nhập đúng định dạng của số điện thoại")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
