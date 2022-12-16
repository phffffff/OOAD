/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
 
/**
 *
 * @author Acer
 */
import java.sql.Date;

public class PhieuGiamGiaDTO {
    private String ma_phieu_giam_gia;
    private String ten_phieu_giam_gia;
    private int giam;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;
    private int trang_thai;
    
    public PhieuGiamGiaDTO() {
    }

    public PhieuGiamGiaDTO(String ma_phieu_giam_gia, String ten_phieu_giam_gia, int giam, Date ngay_bat_dau, Date ngay_ket_thuc, int trang_thai) {
        this.ma_phieu_giam_gia = ma_phieu_giam_gia;
        this.ten_phieu_giam_gia = ten_phieu_giam_gia;
        this.giam = giam;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
        this.trang_thai = trang_thai;
    }

    
    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }
    public String getMa_phieu_giam_gia() {
        return ma_phieu_giam_gia;
    }

    public void setMa_phieu_giam_gia(String ma_phieu_giam_gia) {
        this.ma_phieu_giam_gia = ma_phieu_giam_gia;
    }

    public String getTen_phieu_giam_gia() {
        return ten_phieu_giam_gia;
    }

    public void setTen_phieu_giam_gia(String ten_phieu_giam_gia) {
        this.ten_phieu_giam_gia = ten_phieu_giam_gia;
    }

    public int getGiam() {
        return giam;
    }

    public void setGiam(int giam) {
        this.giam = giam;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

}

