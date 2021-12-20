package com.example.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String ten;
    private String ma;

    public SinhVien() {
    }

    public SinhVien(String ten, String ma) {
        this.ten = ten;
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + this.ten + '\'' +
                ", ma='" + this.ma + '\'' +
                '}';
    }
}
