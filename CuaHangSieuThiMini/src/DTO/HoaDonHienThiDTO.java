/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * 
 * @author mizuk
 */
public class HoaDonHienThiDTO{

    
    private String ten_mon;
    private int gia;
    private int so_luong;
    private int thanh_tien;
     
    public HoaDonHienThiDTO(){}
    
        public HoaDonHienThiDTO(String ten_mon, int gia_mon, int so_luong, int thanh_tien) {
        this.ten_mon = ten_mon;
        this.gia = gia;
        this.so_luong = so_luong;
        this.thanh_tien = thanh_tien;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

}
