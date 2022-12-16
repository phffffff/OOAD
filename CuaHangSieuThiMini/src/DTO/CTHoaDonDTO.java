/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/** 
 *
 * @author mizuk 
 */
public class CTHoaDonDTO {

    public CTHoaDonDTO(String ma_hoa_don, String ma_mon, String ten_mon, int so_luong, int gia_mon, int thanh_tien) {
        this.ma_hoa_don = ma_hoa_don;
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.so_luong = so_luong;
        this.gia_mon = gia_mon;
        this.thanh_tien = thanh_tien;
    }
    
    private String ma_hoa_don;
    private String ma_mon;
    private String ten_mon;
    private int so_luong;
    private int gia_mon;
    private int thanh_tien;    
    
    public CTHoaDonDTO(){
    }
    
    public String getMa_hoa_don() {
        return ma_hoa_don;
    }

    public void setMa_hoa_don(String ma_hoa_don) {
        this.ma_hoa_don = ma_hoa_don;
    }

    public String getMa_mon() {
        return ma_mon;
    }

    public void setMa_mon(String ma_mon) {
        this.ma_mon = ma_mon;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getGia_mon() {
        return gia_mon;
    }

    public void setGia_mon(int gia_mon) {
        this.gia_mon = gia_mon;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }
}
